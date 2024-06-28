package com.example.bkshlf.service;


import com.example.bkshlf.response.LoginResponse;
import com.example.bkshlf.model.LoginRequest;
import com.example.bkshlf.model.User;
import com.example.bkshlf.repository.UserRepository;
import com.example.bkshlf.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService
{
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public LoginResponse loginUser(LoginRequest request) throws NoSuchAlgorithmException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        Optional<User> optionalUser = userRepository.findByEmail(request.getEmail());
        User user = optionalUser.get();
        var jwtToken = jwtService.generateToken(user);
        return LoginResponse.builder().accessToken(jwtToken).build();
    }
}
