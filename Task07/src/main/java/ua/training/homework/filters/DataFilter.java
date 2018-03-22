package ua.training.homework.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.training.homework.constants.TextConstants.*;
import static ua.training.homework.constants.TextConstants.INDEX_JSP_PATH;
import static ua.training.homework.filters.RegExp.LOGIN_REGEXP;
import static ua.training.homework.filters.RegExp.NAME_REGEXP;

/**
 * Максим
 * 21.03.2018
 */
public class DataFilter extends BaseFilter {
    @Override
    public void doFilter(HttpServletRequest servletRequest, HttpServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        final String name = servletRequest.getParameter(NAME_PARAMETER);
        final String login = servletRequest.getParameter(LOGIN_PARAMETER);

        if (!(name.matches(NAME_REGEXP) && login.matches(LOGIN_REGEXP))) {
            servletRequest.setAttribute(MESSAGE_ATTRIBUTE, WRONG_DATA_FORMAT);
            servletRequest.getRequestDispatcher(INDEX_JSP_PATH)
                    .forward(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
