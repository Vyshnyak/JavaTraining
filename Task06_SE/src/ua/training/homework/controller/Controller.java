package ua.training.homework.controller;

import ua.training.homework.exceptions.LoginIsNotUniqueException;
import ua.training.homework.model.Model;
import ua.training.homework.model.entity.Note;
import ua.training.homework.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static ua.training.homework.controller.RegExp.REGEX_LOGIN;
import static ua.training.homework.view.Constants.LOGIN;

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
                view.printMessage("Note is added to notebook!");
                break;
            } catch (LoginIsNotUniqueException e) {
                view.printMessage(String.format(e.getMessage(), e.getLogin()));
                inputNoteChecker.setLogin(utilityController.inputStringValueWithScanner(LOGIN, REGEX_LOGIN));
            }
        }
    }
}
