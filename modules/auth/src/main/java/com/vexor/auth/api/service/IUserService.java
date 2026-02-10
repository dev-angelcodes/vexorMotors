package com.vexor.auth.api.service;

import com.vexor.auth.api.record.CreateUserRecord;
import com.vexor.auth.domain.dto.UserDto;

public interface IUserService {
    UserDto createUser(CreateUserRecord command);
}
