package ua.training.homework.controller;

import ua.training.homework.exceptions.LoginIsNotUniqueException;
import ua.training.homework.model.Model;
import ua.training.homework.model.entity.Note;
import ua.training.homework.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static ua.training.homework.controller.RegExp.REGEX_LOGIN;
import static ua.training.homework.view.Constants.LOGIN;
import static ua.training.homework.view.Constants.NOTE_ADDED;

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
        InputNoteChecker inputNoteChecker = new InputNoteChecker(view, utilityController);
        inputNoteChecker.inputNote();
        while (true) {
            try {
                model.addNote(new Note(inputNoteChecker.getFirstName(), inputNoteChecker.getLogin()));
                view.printMessage(View.bundle.getString(NOTE_ADDED));
                break;
            } catch (LoginIsNotUniqueException e) {
                view.printMessage(String.format(e.getMessage(), e.getLogin()));
                inputNoteChecker.setLogin(utilityController.inputStringValue(LOGIN, REGEX_LOGIN));
            }
        }
    }
}
