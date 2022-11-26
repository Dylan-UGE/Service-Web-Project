package fr.eiffel.bike.corp.container;

import fr.eiffel.bike.corp.data.Feedback;

import java.util.ArrayList;
import java.util.List;

public class FeebackContainer {
    private final List<Feedback> feedbackList = new ArrayList<>();

    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void addFeedback(Feedback feedback) {
        feedbackList.add(feedback);
    }
}
