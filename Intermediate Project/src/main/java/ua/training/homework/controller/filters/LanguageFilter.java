package ua.training.homework.controller.filters;

import ua.training.homework.controller.constants.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static ua.training.homework.controller.constants.Constants.EMPTY_LINE;

/**
 * Максим
 * 06.04.2018
 */
public class LanguageFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String page = request.getPathInfo().replace("/language", EMPTY_LINE);
        request.getSession().setAttribute("page", page);
        String page1 = request.getRequestURI().replace(page, EMPTY_LINE);
        String page2 = page1.replace("/api", EMPTY_LINE);
        request.getRequestDispatcher(page2).forward(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
