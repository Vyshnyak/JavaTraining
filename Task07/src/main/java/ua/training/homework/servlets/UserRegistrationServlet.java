package ua.training.homework.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.training.homework.constants.TextConstants.INDEX_JSP_PATH;
import static ua.training.homework.constants.TextConstants.INPUT_DATA;
import static ua.training.homework.constants.TextConstants.MESSAGE_ATTRIBUTE;

/**
 * Максим
 * 21.03.2018
 */
public class UserRegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(MESSAGE_ATTRIBUTE, INPUT_DATA);
        req.getRequestDispatcher(INDEX_JSP_PATH).forward(req, resp);
    }
}
