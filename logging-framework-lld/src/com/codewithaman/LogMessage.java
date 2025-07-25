package com.codewithaman;

import java.time.LocalDateTime;

public class LogMessage {
    private final LogLevel level;
    private String message;
    private LocalDateTime timestamp;
    private final String threadName;

    public LogMessage(LogLevel level, String message) {
        this.level = level;
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.threadName = Thread.currentThread().getName();
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getThreadName() {
        return threadName;
    }
}
