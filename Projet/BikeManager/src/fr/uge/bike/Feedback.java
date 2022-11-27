package fr.uge.bike;

import java.util.ArrayList;
import java.util.List;

public class Feedback {
    private final List<Integer> grades;
    private final List<String> reviews;

    public Feedback(){
        grades = new ArrayList<>();
        reviews = new ArrayList<>();
    }

    public void addGrade(int grade){
        grades.add(grade);
    }

    public void addreview(String comment){
        reviews.add(comment);
    }

    public double average(){
        return grades.stream().mapToInt(v -> v).average().getAsDouble();
    }

    public List<String> getReviews(){
        return reviews;
    }
}
