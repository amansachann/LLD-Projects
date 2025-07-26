package com.codewithaman;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class TaskManager {

    private Map<String, User> users;
    private Map<String, Task> tasks;

    private TaskManager() {
        this.users = new HashMap<>();
        this.tasks = new HashMap<>();
    }

    private static class TaskManagerSingletonHelper {
        private static TaskManager INSTANCE = new TaskManager();
    }

    public static TaskManager getInstance() {
        return TaskManagerSingletonHelper.INSTANCE;
    }

    // User methods
    public User createUser(String name) {
        User user = new User(name);
        users.put(user.getId(), user);
        return user;
    }

    public User getUserById(String id) {
        return users.get(id);
    }

    // Task methods
    public Task createTask(String title, String description) {
        Task task = new Task(title, description);
        tasks.put(task.getId(), task);
        return task;
    }

    public Task getTaskById(String id) {
        return tasks.get(id);
    }

    public void assignTask(String taskId, String userId) {
        Task task = tasks.get(taskId);
        User user = users.get(userId);
        if(task != null && user != null) {
            task.setAssignee(user);
        }
    }

    public void updateStatus(String taskId, TaskStatus status) {
        Task task = tasks.get(taskId);
        if(task!=null) {
            task.setStatus(status);
        }
    }

    public void updatePriority(String taskId, TaskPriority priority) {
        Task task = tasks.get(taskId);
        if(task!=null) {
            task.setPriority(priority);
        }
    }

    public void addComment(String taskId, String userId, String message) {
        Task task = tasks.get(taskId);
        User user = users.get(userId);
        if(task!=null && user != null && !message.isEmpty()) {
            Comment comment = new Comment(message, user);
            task.addComment(comment);
        }
    }

    public List<Task> getTasksByUser(String userId) {
        return tasks.values().stream().
                filter(task->task.getAssignee().equals(users.get(userId)))
                .collect(Collectors.toList());
    }

    public List<Task> getTaskByStatus(TaskStatus status) {
        return tasks.values().stream()
                .filter(task->task.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    public List<Task> getTaskByPriority(TaskPriority priority) {
        return tasks.values().stream()
                .filter(task->task.getPriority().equals(priority))
                .collect(Collectors.toList());
    }




}
