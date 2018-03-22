package ua.training.homework.servlets;

import ua.training.homework.exceptions.LoginIsNotUniqueException;
import ua.training.homework.model.entity.User;
import ua.training.homework.model.Model;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.training.homework.constants.TextConstants.*;

/**
 * Максим
 * 17.03.2018
 */
public class WelcomePageServlet extends HttpServlet {
    private Model model = new Model();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        final String name = req.getParameter(NAME_PARAMETER);
        final String login = req.getParameter(LOGIN_PARAMETER);

        try {
            model.addUser(new User(name, login));
            req.setAttribute(LOGIN_ATTRIBUTE, login);
            req.getRequestDispatcher(WELCOME_JSP_PATH).forward(req, resp);
        } catch (LoginIsNotUniqueException e) {
            req.setAttribute(MESSAGE_ATTRIBUTE, e.getMessage());
            req.getRequestDispatcher(INDEX_JSP_PATH).forward(req, resp);
        }
    }
}
