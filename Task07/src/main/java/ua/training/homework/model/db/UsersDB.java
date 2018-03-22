package ua.training.homework.model.db;

import ua.training.homework.constants.TextConstants;
import ua.training.homework.exceptions.LoginIsNotUniqueException;

import static ua.training.homework.constants.TextConstants.*;

/**
 * Максим
 * 16.03.2018
 */
public enum UsersDB {
    NOTE_ONE("Макс", "Dentris"),
    NOTE_TWO("Игорь", "Mongolski"),
    NOTE_THREE("Юрий", "Resius"),
    NOTE_FOUR("Наташа", "Fresa");

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

    public static void containsLogin(String login) throws LoginIsNotUniqueException {
        for (UsersDB note : UsersDB.values()) {
            if (note.login.equals(login)) {
                throw new LoginIsNotUniqueException(
                        String.format(LOGIN_IS_NOT_UNIQUE, login));
            }
        }
    }
}
