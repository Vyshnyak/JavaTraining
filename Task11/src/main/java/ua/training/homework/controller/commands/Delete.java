package ua.training.homework.controller.commands;

import ua.training.homework.model.services.NotebookServiceImpl;

import javax.servlet.http.HttpServletRequest;

import static ua.training.homework.constants.TextConstants.*;

/**
 * Максим
 * 11.04.2018
 */
public class Delete implements Command {
    private NotebookServiceImpl service = NotebookServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        service.deleteNote(Integer.valueOf(request.getParameter(PARAM_ID)));
        return URL_DELETE_MENU;
    }
}
