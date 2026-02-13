package com.vexor.auth.domain.mapper;

import com.vexor.auth.domain.dto.UserDto;
import com.vexor.auth.domain.entities.AuthUserEntity;
import com.vexor.auth.domain.record.CreateUserRecord;
import org.mapstruct.*;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    private final ZoneId MADRID = ZoneId.of("Europe/Madrid");


    @Mapping(target = "created", expression = "java(toMadridZoned(user.getCreatedAt()))")
    @Mapping(target = "updated", expression = "java(toMadridZoned(user.getUpdatedAt()))")
    public abstract UserDto toUserDto(AuthUserEntity user);

    public abstract AuthUserEntity toUserEntity(UserDto userDto);

    /* These attributes are ignored because passwordHash is set in the service layer,
    and created/updated are managed automatically by JPA auditing. */
    @Mapping(target = "passwordHash", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    public abstract AuthUserEntity recordToEntity(CreateUserRecord user);



    ZonedDateTime toMadridZoned(Instant instant) {
        return instant == null ? null : instant.atZone(MADRID);
    }
}
