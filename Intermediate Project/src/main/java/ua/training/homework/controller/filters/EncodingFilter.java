package ua.training.homework.controller.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static ua.training.homework.controller.constants.Constants.ATTRIBUTE_LANGUAGE;

/**
 * Максим
 * 01.04.2018
 */
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Object language = request.getSession().getAttribute(ATTRIBUTE_LANGUAGE);
        if (language == null) {
            request.getSession().setAttribute(ATTRIBUTE_LANGUAGE, "en");
        }
        servletResponse.setContentType("text/html");
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
