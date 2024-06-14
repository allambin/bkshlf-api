package com.example.bkshlf.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class EventPublisherService
{
    @Autowired
    private ApplicationEventPublisher publisher;

    public void publishEvent(Object event)
    {
        publisher.publishEvent(event);
    }
}
