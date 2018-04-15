package ua.training.homework.model.services;

import ua.training.homework.controller.exceptions.LoginIsNotUniqueException;
import ua.training.homework.model.dao.DaoFactory;
import ua.training.homework.model.dao.NotebookDao;
import ua.training.homework.model.entity.Note;

import java.util.List;

/**
 * Максим
 * 12.04.2018
 */
public class NotebookServiceImpl implements NotebookService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    public static class Holder {
        static final NotebookServiceImpl INSTANCE = new NotebookServiceImpl();
    }

    public static NotebookServiceImpl getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public void addNote(Note note) throws LoginIsNotUniqueException {
        try(NotebookDao dao = daoFactory.createNoteBookDao()) {
            dao.create(note);
        }
    }

    @Override
    public List<Note> getAllNotes() {
        List<Note> notes;
        try(NotebookDao dao = daoFactory.createNoteBookDao()) {
            notes = dao.findAll();
        }
        return notes;
    }

    @Override
    public Note getNote(int id) {
        Note note;
        try(NotebookDao dao = daoFactory.createNoteBookDao()) {
            note = dao.findById(id);
        }
        return note;
    }

    @Override
    public void updateNote(Note note) {
        try(NotebookDao dao = daoFactory.createNoteBookDao()) {
            dao.update(note);
        }
    }

    @Override
    public void deleteNote(int id) {
        try(NotebookDao dao = daoFactory.createNoteBookDao()) {
            dao.delete(id);
        }
    }
}
