package com.codewithaman;

import java.util.*;

public class LinkedInService {


    private Map<String, User> usersByEmail = new HashMap<>();
    private Map<String, JobPosting> jobPostings = new HashMap<>();

    // 🔒 Private constructor for Singleton
    private LinkedInService() {}

    private static class LinkedInServiceSingleton {
        private static final LinkedInService INSTANCE = new LinkedInService();
    }

    // ✅ Singleton getInstance method
    public static LinkedInService getInstance() {
        return LinkedInServiceSingleton.INSTANCE;
    }

    // ✅ Register new user
    public User register(String name, String email, String password) {
        if (usersByEmail.containsKey(email)) {
            System.out.println("User already exists with email: " + email);
            return null;
        }
        User user = new User(name, email, password);
        usersByEmail.put(email, user);
        System.out.println("User registered successfully: " + name);
        return user;
    }

    // ✅ Login user
    public User login(String email, String password) {
        User user = usersByEmail.get(email);
        if (user != null && user.authenticate(password)) {
            System.out.println("Login successful: " + user.getName());
            return user;
        }
        System.out.println("Invalid credentials for email: " + email);
        return null;
    }

    // ✅ Send connection request
    public void sendConnectionRequest(User from, User to) {
        from.addConnection(to);
        to.addConnection(from);
        to.addNotification(new Notification(NotificationType.CONNECTION_REQUEST,
                from.getName() + " connected with you"));
        System.out.println(from.getName() + " and " + to.getName() + " are now connected.");
    }

    // ✅ Post job
    public void postJob(JobPosting job) {
        jobPostings.put(job.getTitle(), job);
        System.out.println("Job posted: " + job.getTitle() + " at " + job.getCompany());
    }

    // ✅ Apply to job
    public void applyToJob(User user, String jobTitle) {
        JobPosting job = jobPostings.get(jobTitle);
        if (job != null) {
            user.applyToJob(job);
            System.out.println(user.getName() + " applied to " + jobTitle);
        } else {
            System.out.println("Job not found: " + jobTitle);
        }
    }

    // ✅ Send message
    public void sendMessage(User from, User to, String content) {
        from.sendMessage(to, content);
        System.out.println("Message sent from " + from.getName() + " to " + to.getName());
    }

    // ✅ View all job postings
    public void viewAllJobs() {
        for (JobPosting job : jobPostings.values()) {
            System.out.println(job.getTitle() + " @ " + job.getCompany() + " (" + job.getLocation() + ")");
        }
    }
}
