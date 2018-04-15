package ua.training.homework.model.dao;

import ua.training.homework.model.dao.impl.JDBCDaoFactory;

/**
 * Максим
 * 12.04.2018
 */
public abstract class DaoFactory {
    private static DaoFactory daoFactory;

    public abstract NotebookDao createNoteBookDao();

    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            synchronized (DaoFactory.class) {
                if (daoFactory == null) {
                    daoFactory = new JDBCDaoFactory();
                }
            }
        }
        return daoFactory;
    }
}
