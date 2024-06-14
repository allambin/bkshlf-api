package com.example.bkshlf.email;

import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
public class Email
{
    private String to;
    private String subject;
    private String content;

    public Email to(String value)
    {
        to = value;
        return this;
    }

    public Email subject(String value)
    {
        subject = value;
        return this;
    }

    public Email content(String value)
    {
        content = value;
        return this;
    }
}
