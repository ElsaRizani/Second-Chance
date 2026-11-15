package com.example.demo.domain;

import java.time.LocalDateTime;

public class Notification {
    private Long id;
    private Long recipientId;
    private String title;
    private String message;
    private boolean isRead;
    private LocalDateTime sentAt;

    public Notification(Long id, Long recipientId, String title, String message) {
        this.id = id;
        this.recipientId = recipientId;
        this.title = title;
        this.message = message;
        this.isRead = false; // Ne fillim njoftimi i pa lexuar
        this.sentAt = LocalDateTime.now();
    }

    public void markAsRead() {
        this.isRead = true;
    }

    public Long getId() { return id; }
    public Long getRecipientId() { return recipientId; }
    public String getTitle() { return title; }
    public String getMessage() { return message; }
    public boolean isRead() { return isRead; }
    public LocalDateTime getSentAt() { return sentAt; }
}