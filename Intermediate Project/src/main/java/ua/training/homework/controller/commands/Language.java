package ua.training.homework.controller.commands;

import javax.servlet.http.HttpServletRequest;

import static ua.training.homework.controller.constants.Constants.*;
import static ua.training.homework.controller.constants.Constants.ATTRIBUTE_LANGUAGE;
import static ua.training.homework.controller.constants.Constants.PARAMETER_LOCALE;

/**
 * Максим
 * 05.04.2018
 */
public class Language implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().setAttribute(ATTRIBUTE_LANGUAGE, request.getParameter(PARAMETER_LOCALE));
        String page = (String) request.getSession().getAttribute(ATTRIBUTE_PAGE);
        if (page.equals("/index")) {
            return PAGE_INDEX;
        } else {
            return PAGE_MENU;
        }
    }
}
