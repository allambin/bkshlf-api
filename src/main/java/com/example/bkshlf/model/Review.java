package com.example.bkshlf.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "TEXT")
    private String content;
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime createdAt; // todo check how to handle UTC
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime updatedAt; // todo check how to handle UTC

    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonIgnore
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "edition_id")
    private Edition edition;
}
