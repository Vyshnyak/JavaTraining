package ua.training.homework.servlets;

import ua.training.homework.exceptions.DataMismatchRegExpException;
import ua.training.homework.exceptions.LoginIsNotUniqueException;
import ua.training.homework.exceptions.WrongInputDataException;
import ua.training.homework.model.entity.Note;
import ua.training.homework.model.Notebook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.training.homework.RegExp.*;
import static ua.training.homework.TextConstants.*;

/**
 * Максим
 * 17.03.2018
 */
public class GetIndexPageServlet extends HttpServlet {
    private Notebook notebook = new Notebook();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(NOTES_ATTRIBUTE, notebook.getNotes());
        req.getRequestDispatcher(INDEX_JSP_PATH).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        final String name = req.getParameter(NAME_PARAMETER);
        final String login = req.getParameter(LOGIN_PARAMETER);

        try {
            checkInputData(name, login);
            final Note note = new Note(name, login);
            notebook.addNote(note);
        } catch (WrongInputDataException e) {
            req.setAttribute(MESSAGE_ATTRIBUTE, e.getMessage());
        }
        doGet(req, resp);
    }

    private void checkInputData(String name, String login) throws WrongInputDataException {
        checkDataForRegexMatch(name, login);
        checkLoginUniqueness(login);
    }

    private void checkDataForRegexMatch(String name, String login) throws DataMismatchRegExpException {
        if (!(name.matches(NAME_REGEXP) && login.matches(LOGIN_REGEXP))) {
            throw new DataMismatchRegExpException(WRONG_DATA_FORMAT);
        }
    }

    private void checkLoginUniqueness(String login) throws LoginIsNotUniqueException {
        notebook.checkLoginUniqueness(login);
    }
}
