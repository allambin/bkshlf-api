package com.example.bkshlf.response;

import com.example.bkshlf.model.Review;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
public class ReviewsWrapper
{
    private List<Review> reviews;
    @JsonProperty("average_rating")
    private double averageRating;
    @JsonProperty("total_reviews")
    private long totalReviews;
}
