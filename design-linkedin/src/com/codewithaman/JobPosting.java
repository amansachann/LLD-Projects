package com.codewithaman;

import java.util.*;

public class JobPosting {
    private String id;
    private String title;
    private String company;
    private String description;
    private String location;
    private List<User> applicants = new ArrayList<>();

    public JobPosting(String title, String company, String description, String location) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.company = company;
        this.description = description;
        this.location = location;
    }

    public void apply(User user) {
        if (!applicants.contains(user)) {
            applicants.add(user);
        }
    }

    public List<User> getApplicants() {
        return applicants;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }
}

