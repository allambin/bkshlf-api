package com.example.bkshlf.repository;

import com.example.bkshlf.model.Book;
import com.example.bkshlf.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>
{
    @Query("SELECT r FROM Review r JOIN r.book b JOIN r.user WHERE b.id = :bookId")
    Page<Review> findAllForBookId(@Param("bookId") String bookId, Pageable pageable);

    @Query("SELECT AVG(rating) FROM Review r WHERE r.book.id = :bookId")
    Double getAverageRatingForBookId(@Param("bookId") String bookId);

    @Query("SELECT COUNT(*) FROM Review r WHERE r.book.id = :bookId")
    Long countAllForBookId(@Param("bookId") String bookId);
}
