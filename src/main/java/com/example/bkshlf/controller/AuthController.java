package com.example.bkshlf.controller;

import com.example.bkshlf.config.RequestError;
import com.example.bkshlf.dto.LoginResponse;
import com.example.bkshlf.dto.UserDTO;
import com.example.bkshlf.model.LoginRequest;
import com.example.bkshlf.model.User;
import com.example.bkshlf.response.UserWrapper;
import com.example.bkshlf.service.AuthService;
import com.example.bkshlf.service.UserService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@Validated
public class AuthController
{
    private final AuthService authService;

    public AuthController(AuthService authService)
    {
        this.authService = authService;
    }

    @PostMapping()
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) throws NoSuchAlgorithmException {
        return ResponseEntity.ok(authService.loginUser(request));
    }
}
