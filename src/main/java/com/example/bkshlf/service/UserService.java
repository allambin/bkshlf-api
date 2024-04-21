package com.example.bkshlf.service;

import com.example.bkshlf.model.RegistrationRequest;
import com.example.bkshlf.model.User;
import com.example.bkshlf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService
{
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public Optional<User> getUser(long id)
    {
        return userRepository.findById(id);
    }

    public User registerUser(RegistrationRequest request)
    {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        User newUser = new User();
        newUser.setEmail(request.getEmail());
        newUser.setPassword(encodedPassword);
        return userRepository.save(newUser);
    }
}
