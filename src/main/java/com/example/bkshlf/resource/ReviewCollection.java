package com.example.bkshlf.resource;

import com.example.bkshlf.model.Review;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ReviewCollection
{
    public static String wrapper = "reviews";

    private List<Review> reviews;
    @JsonProperty("average_rating")
    private double averageRating;
    @JsonProperty("total_reviews")
    private long totalReviews;
}
