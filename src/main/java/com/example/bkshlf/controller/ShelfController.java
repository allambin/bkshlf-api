package com.example.bkshlf.controller;

import com.example.bkshlf.model.Shelf;
import com.example.bkshlf.model.User;
import com.example.bkshlf.request.ShelfRequest;
import com.example.bkshlf.service.ShelfService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class ShelfController
{
    private final ShelfService shelfService;

    @PostMapping("/shelves")
    public ResponseEntity<String> create(@Valid @RequestBody ShelfRequest request, Principal authUser)
    {
        var user = (User) ((UsernamePasswordAuthenticationToken) authUser).getPrincipal();
        Shelf shelf = shelfService.createShelf(user, request.getName());

        if (shelf != null) {
            return ResponseEntity.ok("Success");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create shelf");
        }
    }

    @DeleteMapping("/shelves/{id}")
    public ResponseEntity<String> create(@PathVariable("id") Long id, Principal authUser)
    {
        var user = (User) ((UsernamePasswordAuthenticationToken) authUser).getPrincipal();
        shelfService.deleteShelf(id, user.getId());

        return ResponseEntity.ok("Success");
    }

    @PostMapping("/shelves/{shelfId}/books/{bookId}")
    public ResponseEntity<String> addBookToShelf(@PathVariable("shelfId") Long shelfId, @PathVariable("bookId") String bookId, Principal authUser)
    {
        var user = (User) ((UsernamePasswordAuthenticationToken) authUser).getPrincipal();
        Shelf shelf = shelfService.addBookToShelf(user, shelfId, bookId);

        if (shelf != null) {
            return ResponseEntity.ok("Success");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create shelf");
        }
    }
}
