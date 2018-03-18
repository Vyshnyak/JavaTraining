package ua.training.homework.model;

import ua.training.homework.model.entity.Note;

import java.util.ArrayList;
import java.util.List;

/**
 * Максим
 * 16.03.2018
 */
public class Model {
    private List<Note> notes = new ArrayList<>();

    public void addNote(Note note) {
        notes.add(note);
    }

    public boolean containsLogin(String login) {
        for (Note note : notes) {
            if (note.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }
}
