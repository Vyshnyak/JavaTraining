package ua.training.homework.controller.filters;

import javax.servlet.*;
import java.io.IOException;

import static ua.training.homework.controller.constants.Constants.*;
import static ua.training.homework.controller.constants.Constants.PARAMETER_START;
import static ua.training.homework.controller.constants.RegExp.NUMBER_RANGE_REGEXP;

/**
 * Максим
 * 01.04.2018
 */
public class DataFormatFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        String start = servletRequest.getParameter(PARAMETER_START);
        String end = servletRequest.getParameter(PARAMETER_END);

        if (start.matches(NUMBER_RANGE_REGEXP) && end.matches(NUMBER_RANGE_REGEXP)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletRequest.setAttribute(ATTRIBUTE_RESULT, MESSAGE_WRONG_INPUT_FORMAT);
            servletRequest.getRequestDispatcher(PAGE_MENU)
                    .forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
