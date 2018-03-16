package ua.training.homework.view;

/**
 * Максим
 * 14.03.2018
 */
public interface Constants {
    String FORWARD_SLASH = "/";
    String NEGATIVE_SIGN = "-";
    String POSITIVE_SIGN = "";

    String BORDER = "=======================";
    String MENU_TITLE = "OPERATIONS";

    String FIRST_PATTERN = "%s %s (%s) = %s";
    String SECOND_PATTERN = "%s %s %s = %s";
    String EXPRESSION_PATTERN = "%d. %s %s %s";

    int NUMERATOR_INDEX = 0;
    int DENOMINATOR_INDEX = 1;
    int ZERO = 0;

    String INPUT_FIRST_FRACTION = "Input first fraction: ";
    String INPUT_SECOND_FRACTION = "Input second fraction: ";
    String INPUT_OPERATION = "Input operation number: ";

    String WRONG_INPUT = "Wrong input! try again!";
    String WRONG_FRACTION = "Wrong fraction! numerator and denominator can't be zero!";
    String WRONG_PROPER_FRACTION = "Wrong proper fraction! numerator should be smaller than denominator!";
    String WRONG_IMPROPER_FRACTION = "Wrong inproper fraction! numerator should be equal to or bigger than denominator!";
}
