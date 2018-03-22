package ua.training.homework.model.entity;

import ua.training.homework.exceptions.LoginIsNotUniqueException;
import ua.training.homework.model.db.UsersDB;

/**
 * Максим
 * 17.03.2018
 */
public class User {
    private String firstName;
    private String login;

    public User(String name, String login) throws LoginIsNotUniqueException {
        UsersDB.containsLogin(login);
        this.firstName = name;
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
