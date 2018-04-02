package ua.training.homework.controller;

import ua.training.homework.controller.commands.*;
import ua.training.homework.model.Model;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Максим
 * 31.03.2018
 */
public class TrainController extends HttpServlet {
    private Map<String, Command> commands = new ConcurrentHashMap<>();

    @Override
    public void init() throws ServletException {
        commands.put("building", new Building());
        commands.put("counting", new Counting());
        commands.put("sorting", new Sorting());
        commands.put("searching", new Searching());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI().replaceAll(".*/app/", "");
        Command command = commands.get(path);
        String page = command.execute(req);
        req.getRequestDispatcher(page).forward(req, resp);
    }
}
