package com.example.bkshlf.controller;

import com.example.bkshlf.model.User;
import com.example.bkshlf.service.UserBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/users")
@Validated
@RequiredArgsConstructor
public class UserBookController
{
    private final UserBookService userBookService;

    @PostMapping("/books/{bookId}/editions/{editionId}")
    public ResponseEntity<String> attachBook(@PathVariable("bookId") String bookId, @PathVariable("editionId") int editionId, Principal authUser)
    {
        var user = (User) ((UsernamePasswordAuthenticationToken) authUser).getPrincipal();
        Boolean result = userBookService.attachBookToUser(user.getId(), bookId, editionId);
        if (result) {
            return ResponseEntity.ok("Success");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to attach book to user");
        }
    }
}
