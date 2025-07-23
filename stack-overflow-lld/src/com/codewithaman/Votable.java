package com.codewithaman;

public interface Votable {
    void addVote(User voter, VoteType voteType);
    int getVoteCount();
}
