package com.vexor.employeeapi.controller;

import com.vexor.auth.api.record.CreateUserRecord;
import com.vexor.auth.api.service.IUserService;
import com.vexor.auth.domain.dto.UserDto;
import com.vexor.commoninfra.jsonapi.JsonApiObject;
import com.vexor.commoninfra.jsonapi.JsonApiResponseBuilder;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Employees User controller", description = "Employee and Admin actions on users")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class AdminUserController {

    private final IUserService userService;

    @PostMapping("/register")
    public ResponseEntity<JsonApiObject<UserDto>> register(@RequestBody @Valid CreateUserRecord recordUser) {
        UserDto userDto = userService.createUser(recordUser);

        var response = JsonApiResponseBuilder.<UserDto>builder()
                .count(1)
                .result(List.of(userDto))
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
