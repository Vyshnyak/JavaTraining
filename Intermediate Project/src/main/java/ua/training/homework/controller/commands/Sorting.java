package ua.training.homework.controller.commands;

import ua.training.homework.model.services.PassengerTrainService;

import javax.servlet.http.HttpServletRequest;

import static ua.training.homework.constants.TextConstants.PAGE_MENU;

/**
 * Максим
 * 31.03.2018
 */
public class Sorting implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        PassengerTrainService service = new PassengerTrainService();
        service.sortWagonsByComfortLevel();
        return PAGE_MENU;
    }
}
