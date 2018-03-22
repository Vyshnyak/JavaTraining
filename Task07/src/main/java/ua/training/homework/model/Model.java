package ua.training.homework.model;

import ua.training.homework.model.entity.User;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Максим
 * 17.03.2018
 */
public class Model {
    private List<User> users = new CopyOnWriteArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User note) {
        users.add(note);
    }
}
