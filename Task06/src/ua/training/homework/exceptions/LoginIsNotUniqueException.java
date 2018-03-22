package ua.training.homework.exceptions;

/**
 * Максим
 * 16.03.2018
 */
public class LoginIsNotUniqueException extends Exception {
    private String login;

    public LoginIsNotUniqueException(String message, String login) {
        super(message);
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
}
