//package com.example.bkshlf.service;
//
//import com.example.bkshlf.model.Book;
//import com.example.bkshlf.model.Review;
//import com.example.bkshlf.model.User;
//import com.example.bkshlf.repository.BookRepository;
//import com.example.bkshlf.repository.ReviewRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class ReviewService
//{
//    private final ReviewRepository reviewRepository;
//    private final LibraryService libraryService;
//
//    public List<Review> getAllReviewsForBook(String bookId)
//    {
//        return null;
////        return reviewRepository.findAllForBookId(bookId);
//    }
//
//    public Review createReview(User user, String bookId, long editionId, String content)
//    {
//        Book book = libraryService.getBookWithEdition(bookId, editionId);
//        if (book == null) {
//            return null; // .orElseThrow(() -> new RuntimeException("User not found"));
//        }
//
//        Review review = new Review();
//        review.setBook(book);
//        review.setEdition(book.getEditions().stream().findFirst().orElse(null));
//        review.setUser(user);
//        return reviewRepository.save(review);
//    }
//
//    public Review updateReview(User user, String bookId, long editionId, String content)
//    {
//        Book book = libraryService.getBookWithEdition(bookId, editionId);
//        if (book == null) {
//            return null; // .orElseThrow(() -> new RuntimeException("User not found"));
//        }
//        return null;
//
////        Review review = reviewRepository.findOneByUserIdAndBookId(user.getId(), bookId);
////        if (review == null) {
////            review = new Review();
////        }
////
////        review = new Review();
////        review.setBook(book);
////        review.setEdition(book.getEditions().stream().findFirst().orElse(null));
////        review.setUser(user);
////        return reviewRepository.save(review);
//    }
//}
