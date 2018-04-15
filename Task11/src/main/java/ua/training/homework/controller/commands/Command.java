package ua.training.homework.controller.commands;

import javax.servlet.http.HttpServletRequest;

/**
 * Максим
 * 11.04.2018
 */
public interface Command {
    String execute(HttpServletRequest request);
}
