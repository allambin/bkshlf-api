package com.example.bkshlf.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;

public class CustomErrorController implements ErrorController
{
    @RequestMapping("/error")
    public HttpStatus handleError()
    {
        return HttpStatus.NOT_FOUND;
    }

    public String getErrorPath()
    {
        return "/error";
    }
}
