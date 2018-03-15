package ua.training.homework.controller;

import ua.training.homework.view.Constants;
import ua.training.homework.view.View;

import java.util.Scanner;

/**
 * Максим
 * 14.03.2018
 */
public class UtilController {
    private View view;
    private Scanner scanner;

    public UtilController(View view, Scanner scanner) {
        this.view = view;
        this.scanner = scanner;
    }

    public String getInputFromUser(String message, String regex) {
        String result;
        view.printInputMessage(message);
        while (!(scanner.hasNext() && (result = scanner.next())
                .matches(regex))) {
            view.printMessage(Constants.WRONG_INPUT);
            view.printInputMessage(message);
        }
        return result;
    }
}
