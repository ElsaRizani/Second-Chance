package com.example.demo.domain;

import java.time.LocalDate;

public class Announcement {
    private Long id;
    private String title;
    private String content;
    private LocalDate publishedDate;
    private boolean active; 

    public Announcement(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.publishedDate = LocalDate.now();
        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public LocalDate getPublishedDate() { return publishedDate; }
    public boolean isActive() { return active; }
}