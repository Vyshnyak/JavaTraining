package ua.training.homework.controller;

import ua.training.homework.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Максим
 * 16.03.2018
 */
public class UtilityController {
    private BufferedReader reader;
    private View view;

    public UtilityController(BufferedReader reader, View view) {
        this.reader = reader;
        this.view = view;
    }

    String inputStringValueWithScanner(String message, String regex) throws IOException {
        String res;
        view.printStringInput(message);
        while(!(res = reader.readLine()).matches(regex)) {
            view.printWrongStringInput(message);
        }
        return res;
    }
}
