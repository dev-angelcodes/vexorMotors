package com.vexor.employeeapi.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Employees User controller", description = "Employee and Admin actions on users")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class AdminUserController {
}
