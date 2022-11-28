package fr.uge.bike.data;

import java.io.Serializable;

public class User implements Serializable {
    private final String username;
    private final String email;

    public User(String username, String email) {
        super();
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return username + " : " + email;
    }
}
