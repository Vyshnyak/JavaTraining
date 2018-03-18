package ua.training.homework.model.entity;

import ua.training.homework.exceptions.LoginIsNotUniqueException;
import ua.training.homework.model.db.NotebookDB;
import ua.training.homework.view.View;

import static ua.training.homework.view.Constants.LOGIN_IS_NOT_UNIQUE_ERROR;

/**
 * Максим
 * 16.03.2018
 */
public class Note {
    private String firstName;
    private String login;

    public Note(String name, String login) throws LoginIsNotUniqueException {
        if (NotebookDB.containsLogin(login)) {
            throw new LoginIsNotUniqueException(
                    View.bundle.getString(LOGIN_IS_NOT_UNIQUE_ERROR), login);
        }
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
