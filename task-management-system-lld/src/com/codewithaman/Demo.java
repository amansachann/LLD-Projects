package com.codewithaman;

public class Demo {
    public static void main(String[] args) {
        TaskManager manager = TaskManager.getInstance();

        User aman = manager.createUser("Aman");
        User akash = manager.createUser("Akash");

        Task task = manager.createTask("Fix bug #123", "Fix the null pointer exception which is recently detected in the logs");
        manager.assignTask(task.getId(), akash.getId());
        manager.updatePriority(task.getId(), TaskPriority.HIGH);
        manager.updateStatus(task.getId(), TaskStatus.IN_PROGRESS);
        manager.addComment(task.getId(), aman.getId(), "Please fix it asap");
        System.out.println("Tasks for Akash: ");
        for(Task t: manager.getTasksByUser(akash.getId())) {
            System.out.println(t);
        }
    }
}
