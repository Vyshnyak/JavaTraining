package ua.training.homework.controller.commands;

import ua.training.homework.model.services.PassengerTrainService;

import javax.servlet.http.HttpServletRequest;

import static ua.training.homework.constants.TextConstants.*;

/**
 * Максим
 * 31.03.2018
 */
public class Counting implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        PassengerTrainService service = new PassengerTrainService();
        int passengers = service.countPassengers();
        double baggage = service.countBaggage();
        request.setAttribute(ATTRIBUTE_PASSENGERS, passengers);
        request.setAttribute(ATTRIBUTE_BAGGAGE, baggage);
        request.setAttribute(ATTRIBUTE_COUNT_RESULT, PATTERN_RESULT);
        return PAGE_MENU;
    }
}
