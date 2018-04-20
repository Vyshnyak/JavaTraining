package ua.training.homework.controller.commands;

import ua.training.homework.controller.commands.validators.CommandValidatorHelper;
import ua.training.homework.controller.exceptions.LoginIsNotUniqueException;
import ua.training.homework.model.entity.Note;
import ua.training.homework.model.services.NotebookServiceImpl;

import javax.servlet.http.HttpServletRequest;

import static ua.training.homework.constants.TextConstants.*;

/**
 * Максим
 * 11.04.2018
 */
public class Create implements Command {
    private NotebookServiceImpl service = NotebookServiceImpl.getInstance();
    private CommandValidatorHelper validatorHelper = CommandValidatorHelper.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        if (validatorHelper.matchesValidate(request)) {
            Note note = new Note();
            note.setFirstName(request.getParameter(PARAM_FIRST_NAME));
            note.setLogin(request.getParameter(PARAM_LOGIN));
            try {
                service.addNote(note);
            } catch (LoginIsNotUniqueException e) {
                request.setAttribute(ATTRIBUTE_MESSAGE,
                        String.format(MESSAGE_LOGIN_IS_NOT_UNIQUE, e.getLogin()));
                //return PAGE_CREATE_FORM;
            }
        }
        return URL_READ;
        //return PAGE_INDEX;
    }
}
