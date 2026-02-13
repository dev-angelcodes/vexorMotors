package com.vexor.auth.api.service;

import com.vexor.auth.domain.record.AuthTokensRecord;
import com.vexor.auth.domain.record.CreateUserRecord;
import com.vexor.auth.domain.record.LoginUserRecord;
import com.vexor.auth.domain.dto.UserDto;
import com.vexor.commoninfra.jsonapi.JsonApiObject;

public interface IUserService {
    JsonApiObject<UserDto> createUser(CreateUserRecord user);
    AuthTokensRecord loginUser(LoginUserRecord user);
    AuthTokensRecord refreshToken(String refreshToken);
}
