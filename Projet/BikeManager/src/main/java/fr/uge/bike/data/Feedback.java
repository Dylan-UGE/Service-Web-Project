package fr.uge.bike.data;

import java.io.Serializable;

public class Feedback implements Serializable {
    private User user;

    private int score;

    private String comment;

    public Feedback() {}

    public Feedback(User user, int score) {
        this.user = user;
        this.score = score;
        this.comment = "";
    }

    public Feedback(User user, int score, String comment) {
        this.user = user;
        this.score = score;
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return user + " : " + score + "/20" + " [" + comment + " ]";
    }
}