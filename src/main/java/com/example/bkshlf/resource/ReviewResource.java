package com.example.bkshlf.resource;

import com.example.bkshlf.model.Book;
import com.example.bkshlf.model.Review;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ReviewResource extends Resource<Review>
{
    public static String resourceWrapper = "review";
    public static String collectionWrapper = "reviews";

    private long id;
    private Integer rating;
    private String content;

    @Override
    public Map<String, Object> toArray(Review model)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("id", model.getId());
        map.put("content", model.getContent());
        map.put("rating", model.getRating());
        return map;
    }
}
