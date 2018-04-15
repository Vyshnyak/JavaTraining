package ua.training.homework.controller;

import ua.training.homework.controller.commands.*;

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
 * 31.03.2018
 */
public class TrainServlet extends HttpServlet {
    private Map<String, Command> commands = new HashMap<>();

    @Override
    public void init() throws ServletException {
        commands.put(COMMAND_BUILD, new Build());
        commands.put(COMMAND_FILL, new Fill());
        commands.put(COMMAND_COUNT, new Count());
        commands.put(COMMAND_SORT, new Sort());
        commands.put(COMMAND_SEARCH, new Search());
        commands.put(COMMAND_LANGUAGE, new Language());
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getPathInfo();
        Command command = commands.get(path);
        String page = command.execute(request);
        request.getRequestDispatcher(page).forward(request, response);
    }
}
