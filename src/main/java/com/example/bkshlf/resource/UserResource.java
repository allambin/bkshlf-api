package com.example.bkshlf.resource;

import com.example.bkshlf.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class UserResource extends JsonResource<User>
{
    public UserResource()
    {
        super("user", "users");
    }

    @Override
    public Map<String, Object> toArray(User model)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("id", model.getId());
        map.put("email", model.getEmail());
        return map;
    }
}
