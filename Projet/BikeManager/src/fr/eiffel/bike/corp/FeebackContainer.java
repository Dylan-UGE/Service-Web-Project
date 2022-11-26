package fr.eiffel.bike.corp;

import java.util.ArrayList;
import java.util.List;

public class FeebackContainer {
    private final List<Feedback> feedbackList = new ArrayList<>();

    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }
}
