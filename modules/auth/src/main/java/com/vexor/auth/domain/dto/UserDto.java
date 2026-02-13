package com.vexor.auth.domain.dto;


import com.vexor.auth.domain.enums.UserRole;


import java.time.ZonedDateTime;
import java.util.UUID;

public record UserDto(
        UUID id,
        String email,
        String firstName,
        String lastName,
        UserRole role,
        ZonedDateTime created,
        ZonedDateTime updated
) {}
