package ua.training.homework.controller.commands;

import javax.servlet.http.HttpServletRequest;

import static ua.training.homework.TextConstants.*;
import static ua.training.homework.TextConstants.ATTRIBUTE_LANGUAGE;
import static ua.training.homework.TextConstants.PARAMETER_LOCALE;

/**
 * Максим
 * 05.04.2018
 */
public class Language implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().setAttribute(ATTRIBUTE_LANGUAGE, request.getParameter(PARAMETER_LOCALE));
        return request.getParameter(PARAMETER_PAGE_NAME);
    }
}
