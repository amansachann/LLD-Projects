package com.codewithaman;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LinkedInService service = LinkedInService.getInstance();

        // 🔐 Register users
        User alice = service.register("Alice", "alice@mail.com", "1234");
        User bob = service.register("Bob", "bob@mail.com", "5678");

        // 🔑 Login users
        User loggedInAlice = service.login("alice@mail.com", "1234");
        User loggedInBob = service.login("bob@mail.com", "5678");

        // 👩‍💼 Update Alice’s profile
        loggedInAlice.getProfile().addSkill(new Skill("Java"));
        loggedInAlice.getProfile().addExperience(new Experience("Google", "SDE",
                LocalDate.of(2020, 1, 1), LocalDate.of(2022, 1, 1), "Worked on backend systems"));

        // 🤝 Send connection request
        service.sendConnectionRequest(loggedInAlice, loggedInBob);

        // 💬 Send message
        service.sendMessage(loggedInAlice, loggedInBob, "Hey Bob! Let's connect professionally.");

        // 📝 Post job
        JobPosting job = new JobPosting("Software Engineer", "LinkedIn", "Backend role", "Remote");
        service.postJob(job);

        // 👀 View jobs
        System.out.println("\nAvailable Jobs:");
        service.viewAllJobs();

        // 📤 Apply to job
        service.applyToJob(loggedInBob, "Software Engineer");

        // 📥 View inbox & notifications
        System.out.println("\nBob's Inbox:");
        loggedInBob.viewInbox();

        System.out.println("\nBob's Notifications:");
        loggedInBob.viewNotifications();
    }
}

