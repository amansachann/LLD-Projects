package com.codewithaman;

public class Vote {
    private User voter;
    private VoteType type;

    public Vote(User voter, VoteType type) {
        this.voter = voter;
        this.type = type;
    }

    public User getVoter() {
        return voter;
    }

    public VoteType getType() {
        return type;
    }
}
