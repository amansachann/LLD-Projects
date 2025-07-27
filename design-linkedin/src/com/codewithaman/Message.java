package com.codewithaman;

import java.time.LocalDateTime;
import java.util.UUID;

public class Message {
    private String id;
    private User sender;
    private User receiver;
    private String content;
    private LocalDateTime timestamp;

    public Message(User sender, User receiver, String content) {
        this.id = UUID.randomUUID().toString();
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    public String getContent() {
        return content;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}

