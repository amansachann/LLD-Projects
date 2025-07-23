package com.codewithaman;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Question implements Commentable, Votable {
    private String id;
    private String title;
    private String description;
    private User author;
    private LocalDateTime creationDate;
    private List<Answer> answers;
    private List<Comment> comments;
    private List<Tag> tags;
    private List<Vote> votes;
    private Answer acceptedAnswer;

    public Question(String id, String title, String description, User author) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.author = author;
        this.creationDate = LocalDateTime.now();
        this.acceptedAnswer = null;
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
        this.tags = new ArrayList<>();
    }

    public Question(String id, String title, User author, List<Tag> tags) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.author = author;
        this.creationDate = LocalDateTime.now();
        this.acceptedAnswer = null;
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
        this.tags = tags;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public User getAuthor() {
        return author;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    @Override
    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public Answer getAcceptedAnswer() {
        return acceptedAnswer;
    }

    public void setAcceptedAnswer(Answer acceptedAnswer) {
        this.acceptedAnswer = acceptedAnswer;
    }

    @Override
    public void addVote(User voter, VoteType voteType) {
        votes.removeIf(v->v.getVoter().equals(voter));
        this.votes.add(new Vote(voter, voteType));
        // Update reputation
        author.setReputation(author.getReputation() +
                (voteType == VoteType.UPVOTE ?
                        ReputationType.QUESTION_UPVOTE.getPoints() :
                        ReputationType.QUESTION_DOWNVOTE.getPoints()));
    }

    @Override
    public int getVoteCount() {
        return votes.stream().mapToInt(v->v.getType().getValue()).sum();
    }

    public void acceptAnswer(Answer answer) {
        this.acceptedAnswer = answer;
        User answerAuthor = answer.getAuthor();
        answerAuthor.setReputation(answerAuthor.getReputation() + ReputationType.ANSWER_ACCEPTED.getPoints());
    }
}
