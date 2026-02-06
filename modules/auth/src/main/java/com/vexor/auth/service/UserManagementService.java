package com.vexor.auth.service;

import com.vexor.auth.api.UserManagementApi;
import com.vexor.auth.api.record.CreateUserCommand;
import com.vexor.auth.domain.dto.UserDto;
import com.vexor.auth.domain.entities.AuthUserEntity;
import com.vexor.auth.domain.repository.AuthUserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;


@RequiredArgsConstructor
public class UserManagementService implements UserManagementApi {
    private final AuthUserJpaRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto createUser(CreateUserCommand command) {
        var email = command.email().toLowerCase().trim();

        if (userRepository.existsByEmail(email)){
            throw new IllegalArgumentException("Email already exists");
        }

        var password = passwordEncoder.encode(command.password());
        var user = new AuthUserEntity(email, password, command.firstName(), command.lastName(), command.role());

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
