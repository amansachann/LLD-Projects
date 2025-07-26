# Task Management System LLD

## Problem Statement
Design and implement a Task Management System that allows users to create, assign, update, and track tasks. The system should support task priorities, statuses, comments, and user assignment.

---
## Flow
- Start
- User create a task
- User assigns the task to another user
- User sets priority and initial status
- User or assignee add the comments
- User or assignee updates the task as work progresses
- Task marked as DONE
- End

---
## Requirements
- User -> create task -> title, description
- User -> assign task -> other user
- Task -> Status: TODO, IN_PROGRESS, DONE
- Task -> Priority: LOW, MEDIUM, HIGH, CRITICAL
- User -> Update -> status, priority
- User -> add comments
- User -> View task, filter task on basis of priority, status
- Design -> extensible, scalable, maintainable
---
## Assumptions
- No authentication (Third Party Authentication)
- Each task has only one assignee

---
## Actors
- User(s)
- System

---
## Use Case Summary
**User**
- Create a task
- Assign task
- Update task status
- Update task priority
- Add comment

**System**
- Create a user
- Filter task

---
## Design Patterns
- Singleton Pattern -> TaskManager - single point to manage users and tasks
**Optional:**
- Builder Pattern - To create complex task objects
- Strategy Pattern - Filtering Strategy
- Factory - support for different kind of tasks like - bug, issue, story

---
## Core Entities
- Task (id, title, description, status, priority, assignee, creator, List<comments>, createdAt, dueDate)
- User (id, name)
- TaskManager (instance, List<user>, List<task>)
- Comment (id, message, author, createdAt)
- TaskStatus (enum) - TODO, IN_PROGRESS, DONE
- TaskPriority (enum) - LOW, MEDIUM, HIGH, URGENT

---
## Trade-offs
- Used Singleton for task manager - not ideal for multithreaded and distributed systems
- UUID - Slightly hevier for incremental counters 
- One assignee per task 
- Data stored in-memory
- No validation 
- Comment doesn't have reply feature