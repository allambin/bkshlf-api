package com.example.bkshlf.config;

import com.example.bkshlf.controller.CustomErrorController;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomErrorConfig
{
    @Bean
    public ErrorController errorController()
    {
        return new CustomErrorController();
    }
}
