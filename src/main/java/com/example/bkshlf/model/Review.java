package com.example.bkshlf.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="reviews")
public class Review implements AuditableBean
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Integer rating;
    @Column(columnDefinition = "TEXT")
    private String content;
//    @Column(name = "created_at", columnDefinition = "DATETIME")
//    private LocalDateTime createdAt; // todo check how to handle UTC
//    @Column(name = "updated_at", columnDefinition = "DATETIME")
//    private LocalDateTime updatedAt; // todo check how to handle UTC
    @Column(name = "created_at", columnDefinition = "DATETIME")
    private LocalDateTime createdAt;
    @Column(name = "updated_at", columnDefinition = "DATETIME")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonIgnore
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public LocalDateTime getCreated_at() {
        return createdAt;
    }

    @Override
    public void setCreated_at(LocalDateTime created_at) {
        this.createdAt = created_at;
    }

    @Override
    public LocalDateTime getUpdated_at() {
        return updatedAt;
    }

    @Override
    public void setUpdated_at(LocalDateTime updated_at) {
        this.updatedAt = updated_at;
    }
}
