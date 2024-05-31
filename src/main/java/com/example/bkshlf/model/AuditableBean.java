package com.example.bkshlf.model;

import java.time.LocalDateTime;

public interface AuditableBean
{
    LocalDateTime getCreated_at();
    void setCreated_at(LocalDateTime createdAt);
    LocalDateTime getUpdated_at();
    void setUpdated_at(LocalDateTime updatedAt);
}
