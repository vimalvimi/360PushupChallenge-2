package com.example.batman.a360pushupchallenge.model;

public class PushUpStats {

    private int currentAttempt;
    private int currentScore;

    public PushUpStats(int currentAttempt, int currentScore) {
        this.currentAttempt = currentAttempt;
        this.currentScore = currentScore;
    }

    public int getCurrentAttempt() {
        return currentAttempt;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentAttempt(int currentAttempt) {
        this.currentAttempt = currentAttempt;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }
}
