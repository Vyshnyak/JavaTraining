package ua.training.homework.model.db;

import ua.training.homework.exceptions.LoginIsNotUniqueException;
import ua.training.homework.view.View;

import static ua.training.homework.view.Constants.LOGIN_IS_NOT_UNIQUE_ERROR;

/**
 * Максим
 * 16.03.2018
 */
public enum UsersDB {
    USER_ONE("Макс", "Dentris"),
    USER_TWO("Игорь", "Mongolski"),
    USER_THREE("Юрий", "Resius"),
    USER_FOUR("Наташа", "Fresa");

    private String firstName;
    private String login;

    UsersDB(String firstName, String login) {
        this.firstName = firstName;
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

    public static void checkLoginUniqueness(String login) throws LoginIsNotUniqueException {
        for (UsersDB note : UsersDB.values()) {
            if (note.login.equals(login)) {
                throw new LoginIsNotUniqueException(
                        View.bundle.getString(LOGIN_IS_NOT_UNIQUE_ERROR), login);
            }
        }
    }
}
