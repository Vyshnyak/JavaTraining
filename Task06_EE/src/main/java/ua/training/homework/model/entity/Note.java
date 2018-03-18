package ua.training.homework.model.entity;

/**
 * Максим
 * 17.03.2018
 */
public class Note {
    private String firstName;
    private String login;

    public Note(String name, String login) {
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
