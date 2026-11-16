package com.example.demo.domain;

import java.time.LocalDateTime;

public class AuditLog {

    private Long id;
    private Long userId;
    private String action;
    private LocalDateTime timestamp;

    public AuditLog() {
    }

    public AuditLog(Long id, Long userId, String action, LocalDateTime timestamp) {
        this.id = id;
        this.userId = userId;
        this.action = action;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}