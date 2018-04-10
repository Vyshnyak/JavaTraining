package ua.training.homework.controller.commands;

import ua.training.homework.model.services.PassengerTrainService;

import javax.servlet.http.HttpServletRequest;

import java.util.Locale;
import java.util.ResourceBundle;

import static ua.training.homework.TextConstants.*;

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
