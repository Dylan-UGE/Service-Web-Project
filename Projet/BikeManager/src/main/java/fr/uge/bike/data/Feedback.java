package fr.uge.bike.data;

public class Feedback {
    private final User user;

    private final int score;

    private final String comment;

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


    public int getScore() {
        return score;
    }

    public String getComment() {
        return comment;
    }
}