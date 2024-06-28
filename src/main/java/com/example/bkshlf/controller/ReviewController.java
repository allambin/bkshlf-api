package com.example.bkshlf.controller;

import com.example.bkshlf.model.Review;
import com.example.bkshlf.model.User;
import com.example.bkshlf.request.ReviewRequest;
import com.example.bkshlf.resource.ReviewResource;
import com.example.bkshlf.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ReviewController
{
    private final ReviewService reviewService;

    @GetMapping("/books/{bookId}/reviews")
    public ResponseEntity<Object> showAllForBook(@PathVariable("bookId") String bookId)
    {
        List<Review> reviews = reviewService.getAllReviewsForBook(bookId);
        Double averageRating = reviewService.calculateAverageRatingForBook(bookId);
        Long totalReviews = reviewService.getTotalReviewsCountForBook(bookId);
        Map<String, Object> meta = new HashMap<>();
        meta.put("average_rating", averageRating);
        meta.put("total_reviews", totalReviews);
        ReviewResource reviewResource = new ReviewResource();
        return ResponseEntity.ok().body(reviewResource.toCollection(reviews, meta));
    }

    @PostMapping("/books/{bookId}/reviews")
    public ResponseEntity<String> create(@PathVariable("bookId") String bookId, @Valid @RequestBody ReviewRequest request, Principal authUser)
    {
        var user = (User) ((UsernamePasswordAuthenticationToken) authUser).getPrincipal();
        Review review = reviewService.createReview(user, bookId, request.getRating(), request.getContent());

        if (review != null) {
            return ResponseEntity.ok("Success");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create review");
        }
    }
}
