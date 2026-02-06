package com.vexor.auth.api;

import com.vexor.auth.api.record.CreateUserCommand;
import com.vexor.auth.domain.dto.UserDto;

public interface UserManagementApi {
    UserDto createUser(CreateUserCommand command);
}
