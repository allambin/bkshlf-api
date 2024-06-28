package com.example.bkshlf.resource;

import com.example.bkshlf.model.Review;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ReviewResource extends JsonResource<Review>
{
    public ReviewResource()
    {
        super("review", "reviews");
    }

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
