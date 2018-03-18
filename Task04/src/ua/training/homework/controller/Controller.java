package ua.training.homework.controller;

import ua.training.homework.model.entity.Fraction;
import ua.training.homework.model.entity.Operation;
import ua.training.homework.model.entity.ProperFraction;
import ua.training.homework.model.Model;
import ua.training.homework.view.Constants;
import ua.training.homework.view.View;

import java.util.Scanner;

/**
 * Максим
 * 14.03.2018
 */
public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner scanner = new Scanner(System.in);
        UtilController util = new UtilController(view, scanner);
        model.setFirstFraction(getFractionFromUser(util, Constants.INPUT_FIRST_FRACTION));
        model.setSecondFraction(getFractionFromUser(util, Constants.INPUT_SECOND_FRACTION));
        view.printMenu(model.getFirstFraction().toString(), model.getSecondFraction().toString());
        Operation operation = getOperationFromUser(util);
        switch (operation) {
            case ADDITION:
                model.add();
                break;
            case SUBTRACTION:
                model.subtract();
                break;
            case MULTIPLICATION:
                model.multiply();
                break;
            case DIVISION:
                model.divide();
                break;
        }
        view.printMessage(model.getExpressionResult(operation));
    }

    private Operation getOperationFromUser(UtilController util) {
        int operationNumber = Integer.parseInt(
                util.getInputFromUser(Constants.INPUT_OPERATION, RegExp.OPERATION_NUMBER));
        return Operation.values()[--operationNumber];
    }

    private Fraction getFractionFromUser(UtilController utilController, String message) {
        Fraction properFraction;
        while (true) {
            try {
                String[] fraction = utilController
                        .getInputFromUser(message, RegExp.FRACTION)
                        .split(Constants.FORWARD_SLASH);
                properFraction = new ProperFraction(
                        Integer.parseInt(fraction[Constants.NUMERATOR_INDEX]),
                        Integer.parseInt(fraction[Constants.DENOMINATOR_INDEX]));
                break;
            } catch (IllegalArgumentException e) {
                view.printMessage(e.getMessage());
            }
        }
        return properFraction;
    }
}
