package ua.training.homework.controller;

import ua.training.homework.controller.commands.*;
import ua.training.homework.controller.commands.forms.UpdateForm;
import ua.training.homework.controller.commands.menus.DeleteMenu;
import ua.training.homework.controller.commands.menus.UpdateMenu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static ua.training.homework.constants.TextConstants.*;

/**
 * Максим
 * 11.04.2018
 */
public class Servlet extends HttpServlet {
    private Map<String, Command> commands = new HashMap<>();

    @Override
    public void init() throws ServletException {
        commands.put(COMMAND_CREATE, new Create());
        commands.put(COMMAND_READ, new Read());
        commands.put(COMMAND_UPDATE, new Update());
        commands.put(COMMAND_DELETE, new Delete());
        commands.put(COMMAND_UPDATE_FORM, new UpdateForm());
        commands.put(COMMAND_UPDATE_MENU, new UpdateMenu());
        commands.put(COMMAND_DELETE_MENU, new DeleteMenu());
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getPathInfo();
        String page = commands.get(path).execute(request);
        request.getRequestDispatcher(page).forward(request, response);
    }
}
