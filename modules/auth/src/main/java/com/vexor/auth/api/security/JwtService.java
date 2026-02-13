package com.vexor.auth.api.security;


import com.vexor.auth.domain.record.ParsedJwt;
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

    public String generateAccessToken(String subject, Collection<String> roles) {
        var now = Instant.now();
        var expiration = now.plus(props.accessExpirationMinutes(), ChronoUnit.MINUTES);

        return Jwts.builder()
                .issuer(props.issuer())
                .subject(subject)
                .issuedAt(Date.from(now))
                .expiration(Date.from(expiration))
                .claim("roles", List.copyOf(roles))
                .signWith(key)
                .compact();
    }

    public String generateRefreshToken(String subject){
        var now = Instant.now();
        var expiration = now.plus(props.refreshExpirationDays(), ChronoUnit.DAYS);

        return Jwts.builder()
                .issuer(props.issuer())
                .subject(subject)
                .issuedAt(Date.from(now))
                .expiration(Date.from(expiration))
                .claim("type", "refresh")
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

        var type = claims.get("type", String.class);

        return new ParsedJwt(subject, roles, type);
    }
}