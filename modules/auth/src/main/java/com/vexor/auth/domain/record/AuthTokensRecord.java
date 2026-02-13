package com.vexor.auth.domain.record;

public record AuthTokensRecord(
        String accessToken,
        String refreshToken,
        String tokenType,
        long expiresInSeconds
) {
}
