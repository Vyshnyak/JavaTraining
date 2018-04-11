package ua.training.homework.controller.util;

import javax.servlet.http.HttpServletRequest;

import static ua.training.homework.constants.RegExp.NUMBER_RANGE_REGEXP;
import static ua.training.homework.constants.TextConstants.PARAMETER_END;
import static ua.training.homework.constants.TextConstants.PARAMETER_START;

/**
 * Максим
 * 06.04.2018
 */
public class ControllerUtil {
    public static void checkRangeInputFormat(HttpServletRequest request) {
        String start = request.getParameter(PARAMETER_START);
        String end = request.getParameter(PARAMETER_END);
        if (!(start.matches(NUMBER_RANGE_REGEXP) && end.matches(NUMBER_RANGE_REGEXP))) {
            throw new IllegalArgumentException();
        }
    }
}
