package com.example.bkshlf.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.time.LocalDateTime;
import java.lang.reflect.Field;

@Configuration
public class AuditingEntityListener {

    @Autowired
    private Environment environment;

    public void touch(Object target) {
        LocalDateTime now = LocalDateTime.now();
        try {
            Field createdAtField = target.getClass().getDeclaredField("created_at");
            createdAtField.setAccessible(true);
            createdAtField.set(target, now);

            Field updatedAtField = target.getClass().getDeclaredField("updated_at");
            updatedAtField.setAccessible(true);
            updatedAtField.set(target, now);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}


