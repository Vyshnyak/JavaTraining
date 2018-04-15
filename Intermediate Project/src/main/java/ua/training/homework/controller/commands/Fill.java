package ua.training.homework.controller.commands;

import ua.training.homework.model.services.PassengerTrainService;

import javax.servlet.http.HttpServletRequest;

import static ua.training.homework.constants.TextConstants.*;

/**
 * Максим
 * 05.04.2018
 */
public class Fill implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        PassengerTrainService trainService = new PassengerTrainService();
        trainService.fillTrainRandomly();
        return PAGE_MENU;
    }
}
