package com.example.bkshlf.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="editions")
public class Edition
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String isbn10;
    private String isbn13;
    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonIgnore
    private Book book;
}
