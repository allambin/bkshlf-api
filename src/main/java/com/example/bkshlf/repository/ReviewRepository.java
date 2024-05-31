//package com.example.bkshlf.repository;
//
//import com.example.bkshlf.model.Book;
//import com.example.bkshlf.model.Review;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface ReviewRepository extends JpaRepository<Review, Long>
//{
////    @Query("SELECT r FROM Review r JOIN r.book.id b JOIN r.edition JOIN r.user.id WHERE b.id = :bookId")
////    List<Review> findAllForBookId(@Param("bookId") String bookId);
//
////    @Query("SELECT r FROM Review r WHERE r.book_id = :bookId AND r.user_id = :userId")
////    Review findOneByUserIdAndBookId(@Param("userId") long userId, @Param("bookId") String bookId);
//}
