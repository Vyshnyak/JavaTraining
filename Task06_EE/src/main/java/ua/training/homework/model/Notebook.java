package ua.training.homework.model;

import ua.training.homework.exceptions.LoginIsNotUniqueException;
import ua.training.homework.model.entity.Note;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static ua.training.homework.TextConstants.LOGIN_IS_NOT_UNIQUE;

/**
 * Максим
 * 17.03.2018
 */
public class Notebook {
    private List<Note> notes = new CopyOnWriteArrayList<>();

    public List<Note> getNotes() {
        return notes;
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public void checkLoginUniqueness(String login) throws LoginIsNotUniqueException {
        for (Note note : notes) {
            if (note.getLogin().equals(login)) {
                throw new LoginIsNotUniqueException(String.format(LOGIN_IS_NOT_UNIQUE, login));
            }
        }
    }
}
