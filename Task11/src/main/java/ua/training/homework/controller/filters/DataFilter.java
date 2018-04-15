package ua.training.homework.controller.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.training.homework.constants.TextConstants.*;
import static ua.training.homework.constants.TextConstants.PAGE_INDEX;
import static ua.training.homework.controller.filters.RegExp.LOGIN_REGEXP;
import static ua.training.homework.controller.filters.RegExp.NAME_REGEXP;

/**
 * Максим
 * 21.03.2018
 */
public class DataFilter extends BaseFilter {
    @Override
    public void doFilter(HttpServletRequest servletRequest, HttpServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        final String name = servletRequest.getParameter(PARAM_FIRST_NAME);
        final String login = servletRequest.getParameter(PARAM_LOGIN);

        if (!(name.matches(NAME_REGEXP) && login.matches(LOGIN_REGEXP))) {
            servletRequest.setAttribute(ATTRIBUTE_MESSAGE, MESSAGE_WRONG_DATA_FORMAT);
            servletRequest.getRequestDispatcher(PAGE_INDEX)
                    .forward(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
