package ua.training.homework;

import ua.training.homework.controller.Controller;
import ua.training.homework.model.Model;
import ua.training.homework.view.View;

import java.io.IOException;

/**
 * Максим
 * 16.03.2018
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Controller controller = new Controller(new Model(), new View());
        controller.processUser();
    }
}
