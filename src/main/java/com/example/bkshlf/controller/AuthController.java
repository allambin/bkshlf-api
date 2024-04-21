package com.example.bkshlf.controller;

import com.example.bkshlf.config.RequestError;
import com.example.bkshlf.dto.UserDTO;
import com.example.bkshlf.model.LoginRequest;
import com.example.bkshlf.model.User;
import com.example.bkshlf.response.UserWrapper;
import com.example.bkshlf.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@Validated
public class AuthController
{
    private final UserService userService;

    public AuthController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request)
    {
        Optional<User> optionalUser = userService.loginUser(request);
        User user = optionalUser.orElse(null);

        if (user != null) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setEmail(user.getEmail());

            return ResponseEntity.ok(new UserWrapper(userDTO));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new RequestError("User not found"));
    }
}
