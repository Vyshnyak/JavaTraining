package ua.training.homework.controller.filters;

import ua.training.homework.model.services.PassengerTrainService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.training.homework.controller.constants.Constants.*;

/**
 * Максим
 * 05.04.2018
 */
public class AccessFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        String path = ((HttpServletRequest) servletRequest)
                .getRequestURI().replaceAll(ALL_BEFORE_COMMAND, EMPTY_LINE);

        if (PassengerTrainService.model.getTrain() == null &&
                !path.equals(COMMAND_BUILDING) && !path.contains(COMMAND_LANGUAGE)) {
            ((HttpServletResponse) servletResponse).sendRedirect("/api");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
