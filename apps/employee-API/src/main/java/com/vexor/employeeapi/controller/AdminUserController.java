package com.vexor.employeeapi.controller;

import com.vexor.auth.domain.record.AuthTokensRecord;
import com.vexor.auth.domain.record.CreateUserRecord;
import com.vexor.auth.api.service.IUserService;
import com.vexor.auth.domain.dto.UserDto;
import com.vexor.auth.domain.record.LoginUserRecord;
import com.vexor.commoninfra.jsonapi.JsonApiObject;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Employees User controller", description = "Employee and Admin actions on users")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class AdminUserController {

    private final IUserService userService;


    @PostMapping("/login")
    public AuthTokensRecord login(@RequestBody @Valid LoginUserRecord credential) {
        return userService.loginUser(credential);
    }


    @PostMapping("/register")
    @PreAuthorize("hasRole('ADMIN')") //Only ADMIN can register employees/clients (or another ADMIN)
    public ResponseEntity<JsonApiObject<UserDto>> register(@RequestBody @Valid CreateUserRecord user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }
}
