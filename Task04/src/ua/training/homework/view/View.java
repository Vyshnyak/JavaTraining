package ua.training.homework.view;

import ua.training.homework.model.entity.Operation;

/**
 * Максим
 * 14.03.2018
 */
public class View {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printInputMessage(String message) {
        System.out.print(message);
    }

    public void printTitle(String menuTitle) {
        printMessage(Constants.BORDER);
        printMessage(menuTitle);
        printMessage(Constants.BORDER);
    }

    public void printMenu(String firstFraction, String secondFraction) {
        printTitle(Constants.MENU_TITLE);
        int number = Constants.ZERO;
        for (Operation operation : Operation.values()) {
            printMessage(String.format(Constants.EXPRESSION_PATTERN, ++number, firstFraction,
                    operation.getOperation(), secondFraction));
        }
        printMessage(Constants.BORDER);
    }
}
