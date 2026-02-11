package com.vexor.employeeapi.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtTokenAuthentication extends AbstractAuthenticationToken {
    private final String principal;
    private final String token;

    private JwtTokenAuthentication(String principal, String token, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.token = token;
        setAuthenticated(authorities != null);
    }

    public static JwtTokenAuthentication unauthenticated(String token) {
        return new JwtTokenAuthentication(null, token, null);
    }

    public static JwtTokenAuthentication authenticated(
            String principal,
            String token,
            Collection<? extends GrantedAuthority> authorities
    ) {
        return new JwtTokenAuthentication(principal, token, authorities);
    }

    public String token() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }
}
