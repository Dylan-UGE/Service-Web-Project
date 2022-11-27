package fr.uge.bike;

public class Person {
    private final String firstName;
    private final String lastName;
    private final Function function;

    public Person(String firstName, String lastName, Function function) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.function = function;
    }
}
