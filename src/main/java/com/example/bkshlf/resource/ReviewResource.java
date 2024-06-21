package com.example.bkshlf.resource;

import com.example.bkshlf.model.Book;
import com.example.bkshlf.model.Review;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewResource extends Resource<Review, ReviewResource>
{
    public static String resourceWrapper = "review";
    public static String collectionWrapper = "reviews";

    private long id;
    private Integer rating;
    private String content;

    @Override
    public ReviewResource toArray(Review model)
    {
        this.setId(model.getId());
        this.setContent(model.getContent());
        this.setRating(model.getRating());
        return this;
    }
}
