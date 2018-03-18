package ua.training.homework.controller;

import ua.training.homework.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

import static ua.training.homework.controller.RegExp.*;
import static ua.training.homework.view.Constants.*;

/**
 * Максим
 * 16.03.2018
 */
public class InputNoteChecker {
    private View view;
    private UtilityController utilityController;

    private String firstName;
    private String login;

    public InputNoteChecker(View view, UtilityController utilityController) {
        this.view = view;
        this.utilityController = utilityController;
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

    public void inputNote() throws IOException {
        this.firstName = utilityController.inputStringValueWithScanner(FIRST_NAME, View.bundle.getString(REGEX_NAME));
        this.login = utilityController.inputStringValueWithScanner(LOGIN, REGEX_LOGIN);
    }
}
