package com.codewithaman;

import java.time.LocalDateTime;
import java.util.UUID;

public class Comment {
    private String id;
    private String message;
    private User author;
    private LocalDateTime createdAt;

    public Comment(String message, User author) {
        this.message = message;
        this.author = author;
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public User getAuthor() {
        return author;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
