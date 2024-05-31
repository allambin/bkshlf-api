package com.example.bkshlf.controller;

import com.example.bkshlf.model.Book;
import com.example.bkshlf.model.Review;
import com.example.bkshlf.model.User;
import com.example.bkshlf.request.ReviewRequest;
import com.example.bkshlf.response.BooksWrapper;
import com.example.bkshlf.response.ResponseKey;
import com.example.bkshlf.response.ReviewsWrapper;
import com.example.bkshlf.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController
{
    private final ReviewService reviewService;

    @GetMapping("/books/{bookId}/reviews")
    //@ResponseKey("reviews")
    public ReviewsWrapper showAllForBook(@PathVariable("bookId") String bookId)
    {
        List<Review> reviews = reviewService.getAllReviewsForBook(bookId);
        double averageRating = reviewService.calculateAverageRatingForBook(bookId);
        long totalReviews = reviewService.getTotalReviewsCountForBook(bookId);
        ReviewsWrapper wrapper = new ReviewsWrapper();
        wrapper.setReviews(reviews);
        wrapper.setTotalReviews(totalReviews);
        wrapper.setAverageRating(averageRating);
        return wrapper;
//        return ResponseEntity.ok(reviews);
    }

//    @PostMapping("/books/{bookId}/reviews")
//    public ResponseEntity<String> create(@PathVariable("bookId") String bookId, @Valid @RequestBody ReviewRequest request, Principal authUser)
//    {
//        var user = (User) ((UsernamePasswordAuthenticationToken) authUser).getPrincipal();
//        Review review = reviewService.createReview(user, bookId, request.getEditionId(), request.getContent());
//
//        if (review != null) {
//            return ResponseEntity.ok("Success");
//        } else {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create review");
//        }
//    }
//
//    @PutMapping("/books/{bookId}/reviews")
//    public ResponseEntity<String> update(@PathVariable("bookId") String bookId, @Valid @RequestBody ReviewRequest request, Principal authUser)
//    {
//        var user = (User) ((UsernamePasswordAuthenticationToken) authUser).getPrincipal();
//        Review review = reviewService.updateReview(user, bookId, request.getEditionId(), request.getContent());
//
//        if (review != null) {
//            return ResponseEntity.ok("Success");
//        } else {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update review");
//        }
//    }
}
