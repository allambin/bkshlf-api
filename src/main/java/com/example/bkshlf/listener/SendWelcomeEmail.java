package com.example.bkshlf.listener;

import com.example.bkshlf.email.Email;
import com.example.bkshlf.email.EmailService;
import com.example.bkshlf.event.UserRegisteredEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SendWelcomeEmail
{
    @Autowired
    private EmailService emailService;

    @EventListener
    public void handleUserRegisteredEvent(UserRegisteredEvent event)
    {
        Email email = new Email();
        email.subject("Welcome to BKSHLF!").to(event.getUser().getEmail()).content("Welcome!");
        emailService.send(email);
    }
}
