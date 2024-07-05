package com.example.bkshlf.service;

import com.example.bkshlf.config.RestException;
import com.example.bkshlf.event.EventPublisherService;
import com.example.bkshlf.event.UserRegisteredEvent;
import com.example.bkshlf.model.RegistrationRequest;
import com.example.bkshlf.model.Shelf;
import com.example.bkshlf.model.User;
import com.example.bkshlf.repository.ShelfRepository;
import com.example.bkshlf.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService
{
    private final UserRepository userRepository;
    private final ShelfRepository shelfRepository;
    @Autowired
    private EventPublisherService publisherService;

    private boolean passwordMatches(User user, String password)
    {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(password, user.getPassword());
    }

    public User registerUser(RegistrationRequest request)
    {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        User newUser = new User();
        newUser.setEmail(request.getEmail());
        newUser.setPassword(encodedPassword);
        User user = null;
        try {
            user = userRepository.save(newUser);
        } catch (DataIntegrityViolationException e) {
            throw new RestException(HttpStatus.CONFLICT, "Email already exists", e);
        }

        HashMap<String, String> shelves = new HashMap<>();
        shelves.put("reading", "Reading");
        shelves.put("read", "Read");
        shelves.put("want_to_read", "Want to read");
        shelves.put("dnf", "Did not finish");

        for (Map.Entry<String, String> entry : shelves.entrySet()) {
            Shelf shelf = new Shelf();
            shelf.setUser(user);
            shelf.setShortname(entry.getKey());
            shelf.setName(entry.getValue());
            shelf.setIsDefault(true);
            shelfRepository.save(shelf);
        }

        UserRegisteredEvent event = new UserRegisteredEvent(this, user);
        //publisherService.publishEvent(event);

        return user;
    }

    public User findUser(String email)
    {
        return userRepository.findByEmail(email).orElse(null);
    }

    public void deleteUser(Long id)
    {
        userRepository.deleteById(id);
    }
}
