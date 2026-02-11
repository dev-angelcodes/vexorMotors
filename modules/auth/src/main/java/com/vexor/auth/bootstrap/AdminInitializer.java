package com.vexor.auth.bootstrap;

import com.vexor.auth.domain.entities.AuthUserEntity;
import com.vexor.auth.domain.enums.UserRole;
import com.vexor.auth.domain.repository.AuthUserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminInitializer implements CommandLineRunner {

    private final AuthUserJpaRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        String email = "angelfernandezblanco16@gmail.com";
        String password = "12345678";


        if (userRepository.existsByEmail(email)) {
            return;
        }

        AuthUserEntity user = new AuthUserEntity();
        user.setEmail(email);
        user.setPasswordHash(passwordEncoder.encode(password));
        user.setFirstName("Angel");
        user.setLastName("Fernandez Blanco");
        user.setRole(UserRole.ADMIN);

        userRepository.save(user);

        System.out.println("Admin user created: " + email);
    }
}
