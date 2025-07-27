package com.codewithaman;

import java.time.LocalDateTime;

public class Connection {
    private User user;
    private LocalDateTime connectedAt;

    public Connection(User user) {
        this.user = user;
        this.connectedAt = LocalDateTime.now();
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getConnectedAt() {
        return connectedAt;
    }
}
