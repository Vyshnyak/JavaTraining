package ua.training.homework.model.dao.impl;

import ua.training.homework.model.dao.DaoFactory;
import ua.training.homework.model.dao.NotebookDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Максим
 * 12.04.2018
 */
public class JDBCDaoFactory extends DaoFactory {
    @Override
    public NotebookDao createNoteBookDao() {
        return new JDBCNotebookDao(getConnection());
    }

    private Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/notebook_db",
                    "root",
                    "password");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
