package ua.training.homework;

import ua.training.homework.controller.Controller;
import ua.training.homework.model.Model;
import ua.training.homework.view.View;

import java.io.IOException;

/**
 * Максим
 * 05.03.2018
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException, IOException {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.processUser();
    }
}
