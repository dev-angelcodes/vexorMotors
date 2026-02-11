package com.vexor.employeeapi.security;

import com.vexor.auth.api.security.JwtService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.stream.Collectors;

public class JwtAuthenticationProvider implements AuthenticationProvider {
    private final JwtService jwtService;

    public JwtAuthenticationProvider(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) {
        var tokenAuth = (JwtTokenAuthentication) authentication;

        var parsed = jwtService.parseAndValidate(tokenAuth.token());

        var authorities = parsed.roles().stream()
                .map(r -> r.startsWith("ROLE_") ? r : "ROLE_" + r)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());

        return JwtTokenAuthentication.authenticated(parsed.subject(), tokenAuth.token(), authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtTokenAuthentication.class.isAssignableFrom(authentication);
    }
}
