package ua.training.homework.model;

import ua.training.homework.model.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Максим
 * 16.03.2018
 */
public class Model {
    private List<User> users = new ArrayList<>();

    public void addUser(User note) {
        users.add(note);
    }
}
