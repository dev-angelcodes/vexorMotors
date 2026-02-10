package com.vexor.auth.api.service.impl;

import com.vexor.auth.api.record.CreateUserRecord;
import com.vexor.auth.api.service.IUserService;
import com.vexor.auth.domain.dto.UserDto;
import com.vexor.auth.domain.entities.AuthUserEntity;
import com.vexor.auth.domain.repository.AuthUserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final AuthUserJpaRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserDto createUser(CreateUserRecord recUser) {
        var email = recUser.email().toLowerCase().trim();

        if (userRepository.existsByEmail(email)){
            throw new IllegalArgumentException("Email already exists");
        }

        var password = passwordEncoder.encode(recUser.password());
        var user = new AuthUserEntity(email, password, recUser.firstName(), recUser.lastName(), recUser.role());

        var saved = userRepository.save(user);


        return new UserDto(
                saved.getId(),
                saved.getEmail(),
                saved.getFirstName(),
                saved.getLastName(),
                saved.getRole()
        );
    }
}
