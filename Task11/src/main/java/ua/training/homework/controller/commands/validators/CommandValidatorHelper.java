package ua.training.homework.controller.commands.validators;

import javax.servlet.http.HttpServletRequest;

import static ua.training.homework.constants.TextConstants.*;
import static ua.training.homework.controller.filters.RegExp.*;

/**
 * Максим
 * 14.04.2018
 */
public class CommandValidatorHelper {
    private static CommandValidatorHelper instance = new CommandValidatorHelper();

    private CommandValidatorHelper() {
    }

    public static CommandValidatorHelper getInstance() {
        return instance;
    }

    public boolean matchesValidate(HttpServletRequest request) {
        boolean isValid = true;
        if (!(request.getParameter(PARAM_FIRST_NAME).matches(NAME_REGEXP) &&
                request.getParameter(PARAM_LOGIN).matches(LOGIN_REGEXP))) {
            request.setAttribute(ATTRIBUTE_MESSAGE, MESSAGE_WRONG_DATA_FORMAT);
            isValid = false;
        }
        return isValid;
    }
}
