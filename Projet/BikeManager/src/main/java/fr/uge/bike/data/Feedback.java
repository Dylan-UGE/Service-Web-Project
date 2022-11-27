package fr.uge.bike.data;

public class Feedback {
    private final User user;

    private final Bike bike;

    private final int score;

    private final String comment;

    public Feedback(User user, Bike bike, int score, String comment) {
        this.user = user;
        this.bike = bike;
        this.score = score;
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public Bike getBike() {
        return bike;
    }

    public int getScore() {
        return score;
    }

    public String getComment() {
        return comment;
    }
}