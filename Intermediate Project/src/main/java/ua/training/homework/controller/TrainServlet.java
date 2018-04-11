package ua.training.homework.controller;

import ua.training.homework.controller.commands.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static ua.training.homework.constants.TextConstants.*;

/**
 * Максим
 * 31.03.2018
 */
public class TrainServlet extends HttpServlet {
    private Map<String, Command> commands = new ConcurrentHashMap<>();

    @Override
    public void init() throws ServletException {
        commands.put(COMMAND_BUILDING, new Building());
        commands.put(COMMAND_FILLING, new Filling());
        commands.put(COMMAND_COUNTING, new Counting());
        commands.put(COMMAND_SORTING, new Sorting());
        commands.put(COMMAND_SEARCHING, new Searching());
        commands.put(COMMAND_LANGUAGE, new Language());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        Command command = commands.get(path);
        String page = command.execute(req);
        req.getRequestDispatcher(page).forward(req, resp);
    }
}
