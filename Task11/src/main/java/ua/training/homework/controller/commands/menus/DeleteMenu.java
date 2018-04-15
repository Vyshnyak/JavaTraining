package ua.training.homework.controller.commands.menus;

import ua.training.homework.controller.commands.Command;
import ua.training.homework.model.entity.Note;
import ua.training.homework.model.services.NotebookServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static ua.training.homework.constants.TextConstants.*;

/**
 * Максим
 * 13.04.2018
 */
public class DeleteMenu implements Command {
    private NotebookServiceImpl service = NotebookServiceImpl.getInstance();
    @Override
    public String execute(HttpServletRequest request) {
        List<Note> notes = service.getAllNotes();
        request.setAttribute(ATTRIBUTE_NOTES, notes);
        return PAGE_DELETE_MENU;
    }
}
