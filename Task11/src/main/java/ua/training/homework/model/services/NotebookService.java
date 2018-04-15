package ua.training.homework.model.services;

import ua.training.homework.controller.exceptions.LoginIsNotUniqueException;
import ua.training.homework.model.entity.Note;

import java.util.List;

/**
 * Максим
 * 12.04.2018
 */
public interface NotebookService {
    void addNote(Note note) throws LoginIsNotUniqueException;
    List<Note> getAllNotes();
    Note getNote(int id);
    void updateNote(Note note);
    void deleteNote(int id);
}
