package com.vexor.auth.api.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class JwtService {

    private final JwtProperties props;
    private final SecretKey key;

    public JwtService(JwtProperties props) {
        this.props = props;

        this.key = Keys.hmacShaKeyFor(props.secret().getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(String subject, Collection<String> roles) {
        var now = Instant.now();
        var exp = now.plus(props.expirationMinutes(), ChronoUnit.MINUTES);

        return Jwts.builder()
                .issuer(props.issuer())
                .subject(subject)
                .issuedAt(Date.from(now))
                .expiration(Date.from(exp))
                .claim("roles", List.copyOf(roles))
                .signWith(key)
                .compact();
    }

    public ParsedJwt parseAndValidate(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        var subject = claims.getSubject();

        @SuppressWarnings("unchecked")
        var roles = (List<String>) claims.getOrDefault("roles", List.of());

        return new ParsedJwt(subject, roles);
    }

    public record ParsedJwt(String subject, List<String> roles) {}
}