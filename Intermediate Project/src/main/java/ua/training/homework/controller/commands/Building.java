package ua.training.homework.controller.commands;

import ua.training.homework.model.services.PassengerTrainService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static ua.training.homework.constants.TextConstants.*;

/**
 * Максим
 * 31.03.2018
 */
public class Building implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        PassengerTrainService service = new PassengerTrainService();
        service.buildPassengerTrain();
        HttpSession session = request.getSession();
        session.setAttribute(ATTRIBUTE_TRAIN_TYPE, PASSENGER_TRAIN_TITLE);
        session.setAttribute(ATTRIBUTE_TRAIN, PassengerTrainService.model.getTrain());
        return PAGE_MENU;
    }
}
