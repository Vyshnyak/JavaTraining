package ua.training.homework.model.dao.impl;

import ua.training.homework.controller.exceptions.LoginIsNotUniqueException;
import ua.training.homework.model.dao.NotebookDao;
import ua.training.homework.model.entity.Note;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ua.training.homework.constants.TextConstants.*;

/**
 * Максим
 * 12.04.2018
 */
public class JDBCNotebookDao implements NotebookDao {
    private Connection connection;

    public JDBCNotebookDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Note note) throws LoginIsNotUniqueException {
        try (PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO notes (firstName, login) VALUES (?, ?)",
                Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, note.getFirstName());
            ps.setString(2, note.getLogin());
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            while (keys.next()) {
                note.setId(keys.getInt(1));
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new LoginIsNotUniqueException(e.getMessage(), note.getLogin());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Note> findAll() {
        List<Note> notes = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM notes");
            while (resultSet.next()) {
                Note note = extractNoteFromResultSet(resultSet);
                notes.add(note);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return notes;
    }

    @Override
    public Note findById(int id) {
        Note note = null;
        try(PreparedStatement ps = connection.prepareStatement(
                "SELECT * FROM notes WHERE id = ?")) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                note = extractNoteFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return note;
    }

    private Note extractNoteFromResultSet(ResultSet resultSet) throws SQLException {
        Note note = new Note();
        note.setId(resultSet.getInt(PARAM_ID));
        note.setFirstName(resultSet.getString(PARAM_FIRST_NAME));
        note.setLogin(resultSet.getString(PARAM_LOGIN));
        return note;
    }

    @Override
    public void update(Note note) {
        try (PreparedStatement ps = connection.prepareStatement(
                "UPDATE notes SET firstName = ?, login = ? WHERE  id = ?")) {
            ps.setString(1, note.getFirstName());
            ps.setString(2, note.getLogin());
            ps.setInt(3, note.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement ps = connection.prepareStatement(
                "DELETE FROM notes WHERE  id = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
