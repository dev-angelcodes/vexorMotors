package com.vexor.auth.api.security;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableConfigurationProperties(JwtProperties.class)
public class AuthSecurityBeansConfig {

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public JwtService jwtService(JwtProperties props){
        return new JwtService(props);
    }
}
