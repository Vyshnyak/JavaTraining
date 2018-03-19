package ua.training.homework;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    public static final int RAND_MIN = 0;
    public static final int RAND_MAX = 100;
    public static final String SMALLER = "Smaller";
    public static final String BIGGER = "Bigger";
    public static final String SAME = "Same";

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner scanner = new Scanner(System.in);
        model.setLowerBound(RAND_MIN);
        model.setUpperBound(RAND_MAX);
        model.setTargetNumber(rand());
        while (true) {
            model.setEnteredNumber(getNumberWithRange(scanner));
            view.printMessage(View.ENTERED_NUMBER + model.getEnteredNumber());
            model.calculateActionResult();
            model.addStatistic();
            switch (model.getActionResult()) {
                case SMALLER:
                    view.printMessage(View.TARGET_NUMBER + SMALLER);
                    model.setUpperBound(model.getEnteredNumber() - 1);
                    continue;
                case BIGGER:
                    view.printMessage(View.TARGET_NUMBER + BIGGER);
                    model.setLowerBound(model.getEnteredNumber() + 1);
                    continue;
                case SAME:
                    view.printMessage(View.WIN + model.getTargetNumber());
                    view.printMessage(View.STATISTIC + model.getStatistic());
                    break;
            }
            break;
        }
    }

    private int rand(int min, int max) {
        max -= min;
        return (int) (Math.random() * (++max)) + min;
    }

    private int rand() {
        return rand(RAND_MIN, RAND_MAX);
    }

    private int getNumberWithRange(Scanner scanner) {
        view.printMessage(View.INPUT_NUMBER +
                model.getLowerBound() + " - " + model.getUpperBound());
        int number;
        while (true) {
            while (!scanner.hasNextInt()) {
                view.printMessage(View.WRONG_INPUT);
                scanner.next();
            }
            number = scanner.nextInt();
            if (isNumberInRange(number)) {
                break;
            } else {
                view.printMessage(View.OUT_OF_RANGE +
                        model.getLowerBound() + " - " + model.getUpperBound());
            }
        }
        return number;
    }

    private boolean isNumberInRange(int number) {
        return number >= model.getLowerBound() && number <= model.getUpperBound();
    }
}
