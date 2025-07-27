package com.codewithaman;

import java.time.LocalDateTime;
import java.util.UUID;

public class Notification {
    private String id;
    private NotificationType type;
    private String content;
    private LocalDateTime timestamp;

    public Notification(NotificationType type, String content) {
        this.id = UUID.randomUUID().toString();
        this.type = type;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    public String getContent() {
        return content;
    }

    public NotificationType getType() {
        return type;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}

