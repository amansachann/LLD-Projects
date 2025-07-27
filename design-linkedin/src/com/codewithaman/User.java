package com.codewithaman;

import java.util.*;

public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private Profile profile;

    private List<Connection> connections = new ArrayList<>();
    private List<Message> inbox = new ArrayList<>();
    private List<Message> sent = new ArrayList<>();
    private List<Notification> notifications = new ArrayList<>();

    public User(String name, String email, String password) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.password = password;
        this.profile = new Profile(); // initialize empty profile
    }

    public String getEmail() {
        return email;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public void addConnection(User user) {
        this.connections.add(new Connection(user));
    }

    public void receiveMessage(Message message) {
        this.inbox.add(message);
        this.addNotification(new Notification(NotificationType.MESSAGE,
                "New message from " + message.getSender().name));
    }

    public void sendMessage(User receiver, String content) {
        Message message = new Message(this, receiver, content);
        this.sent.add(message);
        receiver.receiveMessage(message);
    }

    public void addNotification(Notification notification) {
        this.notifications.add(notification);
    }

    public void viewInbox() {
        for (Message msg : inbox) {
            System.out.println("From: " + msg.getSender().name + " | " + msg.getContent());
        }
    }

    public void viewNotifications() {
        for (Notification n : notifications) {
            System.out.println(n.getTimestamp() + " | " + n.getType() + " | " + n.getContent());
        }
    }

    public void applyToJob(JobPosting job) {
        job.apply(this);
        this.addNotification(new Notification(NotificationType.JOB_POSTING,
                "You applied to: " + job.getTitle()));
    }

    public Profile getProfile() {
        return profile;
    }

    public String getName() {
        return name;
    }

    public List<Connection> getConnections() {
        return connections;
    }
}
