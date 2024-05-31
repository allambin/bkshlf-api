package com.example.bkshlf.response;

import com.example.bkshlf.model.Review;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ReviewsWrapper
{
    private List<Review> reviews;

    public ReviewsWrapper(List<Review> reviews)
    {
        this.reviews = reviews;
    }

}
