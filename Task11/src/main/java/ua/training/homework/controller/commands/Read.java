package ua.training.homework.controller.commands;

import ua.training.homework.model.entity.Note;
import ua.training.homework.model.services.NotebookServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static ua.training.homework.constants.TextConstants.*;

/**
 * Максим
 * 11.04.2018
 */
public class Read implements Command {
    private NotebookServiceImpl service = NotebookServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        List<Note> notes = service.getAllNotes();
        request.setAttribute(ATTRIBUTE_NOTES, notes);
        return PAGE_READ;
    }
}
