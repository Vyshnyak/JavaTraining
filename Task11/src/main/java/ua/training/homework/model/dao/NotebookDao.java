package ua.training.homework.model.dao;

import ua.training.homework.controller.exceptions.LoginIsNotUniqueException;
import ua.training.homework.model.entity.Note;

import java.util.List;

/**
 * Максим
 * 12.04.2018
 */
public interface NotebookDao extends AutoCloseable {
    void create(Note note) throws LoginIsNotUniqueException;
    List<Note> findAll();
    Note findById(int id);
    void update(Note note);
    void delete(int id);
    void close();
}
