package com.example.bkshlf.controller;

import com.example.bkshlf.dto.LoginResponse;
import com.example.bkshlf.dto.UserDTO;
import com.example.bkshlf.model.LoginRequest;
import com.example.bkshlf.model.RegistrationRequest;
import com.example.bkshlf.model.User;
import com.example.bkshlf.response.UserWrapper;
import com.example.bkshlf.service.AuthService;
import com.example.bkshlf.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/auth")
@Validated
public class AuthController
{
    private final AuthService authService;
    private final UserService userService;

    public AuthController(AuthService authService, UserService userService)
    {
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) throws NoSuchAlgorithmException
    {
        return ResponseEntity.ok(authService.loginUser(request));
    }

    @PostMapping("/register")
    public ResponseEntity<UserWrapper> register(@Valid @RequestBody RegistrationRequest request)
    {
        User registeredUser = userService.registerUser(request);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(registeredUser.getId());
        userDTO.setEmail(registeredUser.getEmail());

        return ResponseEntity.ok(new UserWrapper(userDTO));
    }
}
