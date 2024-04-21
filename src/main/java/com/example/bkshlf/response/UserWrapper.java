package com.example.bkshlf.response;

import com.example.bkshlf.dto.UserDTO;
import com.example.bkshlf.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserWrapper
{
    private UserDTO user;

    public UserWrapper(UserDTO user)
    {
        this.user = user;
    }
}
