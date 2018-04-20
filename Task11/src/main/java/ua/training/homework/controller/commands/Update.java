package ua.training.homework.controller.commands;

import ua.training.homework.controller.commands.validators.CommandValidatorHelper;
import ua.training.homework.model.entity.Note;
import ua.training.homework.model.services.NotebookServiceImpl;

import javax.servlet.http.HttpServletRequest;

import static ua.training.homework.constants.TextConstants.*;

/**
 * Максим
 * 11.04.2018
 */
public class Update implements Command {
    private NotebookServiceImpl service = NotebookServiceImpl.getInstance();
    private CommandValidatorHelper validatorHelper = CommandValidatorHelper.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        if (validatorHelper.matchesValidate(request)) {
            Note note = new Note();
            note.setId(Integer.valueOf(request.getParameter(PARAM_ID)));
            note.setFirstName(request.getParameter(PARAM_FIRST_NAME));
            note.setLogin(request.getParameter(PARAM_LOGIN));
            service.updateNote(note);
            //return URL_UPDATE_MENU;
        }
        return URL_READ;
    }
}
