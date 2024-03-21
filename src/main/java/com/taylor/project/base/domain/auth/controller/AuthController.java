package com.taylor.project.base.domain.auth.controller;

import com.taylor.project.base.common.response.ApiResponse;
import com.taylor.project.base.domain.auth.dto.JoinRequest;
import com.taylor.project.base.domain.auth.dto.LoginRequest;
import com.taylor.project.base.domain.auth.dto.LoginResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/join")
    public ApiResponse<String> join(@Valid @RequestBody JoinRequest request) {
        return ApiResponse.success(null);
    }

    @PostMapping("/login")
    public ApiResponse<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        return ApiResponse.success(null);
    }

}
