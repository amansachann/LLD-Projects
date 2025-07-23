package com.codewithaman;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class StackOverflow {
    private Map<String, User> users;
    private Map<String, Question> questions;
    private Map<String, Answer> answers;
    private Map<String, Tag> tags;

    private StackOverflow() {
        this.users = new ConcurrentHashMap<>();
        this.questions = new ConcurrentHashMap<>();
        this.answers = new ConcurrentHashMap<>();
        this.tags = new ConcurrentHashMap<>();
    }

    private static class Helper {
        private static StackOverflow INSTANCE = new StackOverflow();
    }

    public static StackOverflow getInstance() {
        return Helper.INSTANCE;
    }

    // Create User
    public User createUser(String name, String email) {
        User user = new User(name, email);
        users.put(user.getId(), user);
        return user;
    }

    // Post Question
    public Question postQuestion(String userId, String title, String description,  List<String> tags) {
        List<Tag> tagList = tags.stream().map(t -> new Tag(t)).collect(Collectors.toList());
        Question question = new Question(title, description, users.get(userId), tagList);
        questions.put(question.getId(), question);
        return question;
    }

    // Post Answer
    public Answer postAnswer(String userId, String questionId, String content) {
        Answer ans = new Answer(content, users.get(userId), questions.get(questionId));
        answers.put(ans.getId(), ans);
        return ans;
    }

    // Vote
    private void addVote(String userId, VoteType type, Votable votable) {
        User user = users.get(userId);
        votable.addVote(user, type);
    }

    public void upvote(String userId, Votable votable) {
        addVote(userId, VoteType.UPVOTE, votable);
    }

    public void downvote(String userId, Votable votable) {
        addVote(userId, VoteType.DOWNVOTE, votable);
    }

    // Post Comment
    public void addComment(String userId, Commentable commentable, String text) {
        User user = users.get(userId);
        commentable.addComment(new Comment(text, user));
    }

    // Search functions
    public List<Question> searchQuestions(String query) {
        List<Question> searchResults = questions.values().stream()
                                        .filter(q -> q.getTitle().toLowerCase().contains(query.toLowerCase())
                                                || q.getDescription().toLowerCase().contains(query.toLowerCase()))
                                        .collect(Collectors.toList());
        return searchResults;
    }

    public List<Question> getQuestionsByUser(String userId) {
        User user = users.get(userId);
        List<Question> searchResults = questions.values().stream()
                                        .filter(q -> q.getAuthor().equals(user))
                                        .collect(Collectors.toList());
        return searchResults;
    }

    // Accept Answer
    public void acceptAnswer(String answerId) {
        Answer ans = answers.get(answerId);
        Question ques = ans.getQuestion();
        ques.acceptAnswer(ans);
    }
}
