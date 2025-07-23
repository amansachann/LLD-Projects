package com.codewithaman;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Answer implements Commentable, Votable {

    private String id;
    private String content;
    private User author;
    private LocalDateTime createdAt;
    private Question question;
    private boolean isAccepted;
    private List<Comment> comments;
    private List<Vote> votes;

    public Answer(String content, User author, Question question) {
        this.id = UUID.randomUUID().toString();
        this.content = content;
        this.author = author;
        this.question = question;
        this.createdAt = LocalDateTime.now();
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
        this.isAccepted = false;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Question getQuestion() {
        return question;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    @Override
    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    @Override
    public void addVote(User voter, VoteType voteType) {
        votes.removeIf(v->v.getVoter().equals(voter));
        this.votes.add(new Vote(voter, voteType));
        // Update the reputation
        author.setReputation(author.getReputation() +
                (voteType == VoteType.UPVOTE ?
                        ReputationType.ANSWER_UPVOTE.getPoints() :
                        ReputationType.ANSWER_DOWNVOTE.getPoints()));
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    @Override
    public int getVoteCount() {
        return this.votes.stream().mapToInt(v->v.getType().getValue()).sum();
    }
}
