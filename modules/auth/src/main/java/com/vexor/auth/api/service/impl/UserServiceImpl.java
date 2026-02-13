package com.vexor.auth.api.service.impl;

import com.vexor.auth.domain.mapper.UserMapper;
import com.vexor.auth.domain.record.AuthTokensRecord;
import com.vexor.auth.domain.record.CreateUserRecord;
import com.vexor.auth.domain.record.LoginUserRecord;
import com.vexor.auth.api.security.JwtProperties;
import com.vexor.auth.api.security.JwtService;
import com.vexor.auth.api.service.IUserService;
import com.vexor.auth.domain.dto.UserDto;
import com.vexor.auth.domain.entities.AuthUserEntity;
import com.vexor.auth.domain.repository.AuthUserJpaRepository;
import com.vexor.commoninfra.jsonapi.JsonApiObject;
import com.vexor.commoninfra.jsonapi.JsonApiResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final AuthenticationManager authenticationManager;
    private final AuthUserJpaRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProperties jwtProperties;
    private final JwtService jwtService;
    private final UserMapper userMapper;



    @Override
    @Transactional
    public JsonApiObject<UserDto> createUser(CreateUserRecord recUser) {
        String email = recUser.email().toLowerCase().trim();

        if (userRepository.existsByEmail(email)){
            throw new IllegalArgumentException("Email already exists");
        }

        String passwordHash = passwordEncoder.encode(recUser.password());
        AuthUserEntity user = userMapper.recordToEntity(recUser);
        user.setEmail(email);
        user.setPasswordHash(passwordHash);
        AuthUserEntity saved = userRepository.save(user);

        UserDto userDto = userMapper.toUserDto(saved);

        return JsonApiResponseBuilder.<UserDto>builder()
                .count(1)
                .result(List.of(userDto))
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public AuthTokensRecord loginUser(LoginUserRecord user) {

        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.email(), user.password())
        );

        String email = auth.getName();
        var rol = auth.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();

        var accessToken = jwtService.generateAccessToken(email, rol);

        var refreshToken = jwtService.generateRefreshToken(email);

        return new AuthTokensRecord(
                accessToken,
                refreshToken,
                "Bearer",
                jwtProperties.accessExpirationMinutes() * 60
        );
    }

    @Override
    @Transactional(readOnly = true)
    public AuthTokensRecord refreshToken(String refreshToken) {

        var parsed = jwtService.parseAndValidate(refreshToken);

        if (!"refresh".equals(parsed.type())) {
            throw new IllegalArgumentException("Invalid token type");
        }

        var subject = parsed.subject();

        var user = userRepository.findByEmail(subject)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        var roles = List.of("ROLE_" + user.getRole().name());

        var newAccessToken = jwtService.generateAccessToken(subject, roles);

        return new AuthTokensRecord(
                newAccessToken,
                refreshToken,
                "Bearer",
                jwtProperties.accessExpirationMinutes() * 60
        );
    }
}
