package com.codewithaman;

import java.time.LocalDateTime;
import java.util.UUID;

public class Comment {
    private String id;
    private String text;
    private User user;
    private LocalDateTime creationDate;

    public Comment(String text, User user) {
        this.id = UUID.randomUUID().toString();
        this.text = text;
        this.user = user;
        this.creationDate = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}
