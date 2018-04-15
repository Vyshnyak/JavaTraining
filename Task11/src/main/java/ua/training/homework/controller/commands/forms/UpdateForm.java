package ua.training.homework.controller.commands.forms;

import ua.training.homework.controller.commands.Command;
import ua.training.homework.model.entity.Note;
import ua.training.homework.model.services.NotebookServiceImpl;

import javax.servlet.http.HttpServletRequest;

import static ua.training.homework.constants.TextConstants.*;

/**
 * Максим
 * 13.04.2018
 */
public class UpdateForm implements Command {
    private NotebookServiceImpl service = NotebookServiceImpl.getInstance();
    @Override
    public String execute(HttpServletRequest request) {
        Note note = service.getNote(Integer.valueOf(request.getParameter(PARAM_ID)));
        request.getSession().setAttribute(ATTRIBUTE_NOTE, note);
        return PAGE_UPDATE_FORM;
    }
}
