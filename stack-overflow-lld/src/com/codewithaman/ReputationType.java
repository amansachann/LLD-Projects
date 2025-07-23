package com.codewithaman;

public enum ReputationType {
    QUESTION_UPVOTE(10),
    QUESTION_DOWNVOTE(-2),
    ANSWER_UPVOTE(15),
    ANSWER_DOWNVOTE(-5),
    ANSWER_ACCEPTED(20);

    private final int points;

    ReputationType(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
}
