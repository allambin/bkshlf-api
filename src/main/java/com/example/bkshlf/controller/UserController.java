package com.example.bkshlf.controller;

import com.example.bkshlf.dto.UserDTO;
import com.example.bkshlf.model.RegistrationRequest;
import com.example.bkshlf.model.User;
import com.example.bkshlf.response.UserWrapper;
import com.example.bkshlf.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Validated
@RequiredArgsConstructor
public class UserController
{
    private final UserService userService;

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
