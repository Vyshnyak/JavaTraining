package ua.training.homework.controller;

import ua.training.homework.exceptions.LoginIsNotUniqueException;
import ua.training.homework.model.Model;
import ua.training.homework.model.entity.User;
import ua.training.homework.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static ua.training.homework.controller.RegExp.REGEX_LOGIN;
import static ua.training.homework.view.Constants.LOGIN;
import static ua.training.homework.view.Constants.USER_ADDED;

/**
 * Максим
 * 16.03.2018
 */
public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        UtilityController utilityController = new UtilityController(reader, view);
        InputDataChecker inputNoteChecker = new InputDataChecker(utilityController);
        inputNoteChecker.inputNote();
        while (true) {
            try {
                model.addUser(new User(inputNoteChecker.getFirstName(), inputNoteChecker.getLogin()));
                view.printMessage(View.bundle.getString(USER_ADDED));
                break;
            } catch (LoginIsNotUniqueException e) {
                view.printMessage(String.format(e.getMessage(), e.getLogin()));
                inputNoteChecker.setLogin(utilityController.inputStringValue(LOGIN, REGEX_LOGIN));
            }
        }
    }
}
