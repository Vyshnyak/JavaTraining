package ua.training.homework.controller.filters;

import ua.training.homework.model.services.PassengerTrainService;

import javax.servlet.*;
import java.io.IOException;

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
        String offset = servletRequest.getParameter("offset");
        String end = servletRequest.getParameter("end");

        if (offset.matches("[1-9]?[0-9]?") && end.matches("[1-9]?[0-9]?")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletRequest.setAttribute("train", PassengerTrainService.model.getTrain().drawTrain());
            servletRequest.setAttribute("result", "wrong input format!");
            servletRequest.getRequestDispatcher("/WEB-INF/view/menu.jsp")
                    .forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
