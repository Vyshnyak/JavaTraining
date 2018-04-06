package ua.training.homework.controller.commands;

import ua.training.homework.model.services.PassengerTrainService;

import javax.servlet.http.HttpServletRequest;

import java.util.Locale;
import java.util.ResourceBundle;

import static ua.training.homework.controller.constants.Constants.*;

/**
 * Максим
 * 31.03.2018
 */
public class Counting implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        PassengerTrainService service = new PassengerTrainService();
        ResourceBundle bundle = ResourceBundle.getBundle(BASE_NAME,
                new Locale((String) request.getSession().getAttribute(ATTRIBUTE_LANGUAGE)));

        int passengers = service.countPassengers();
        double baggage = service.countBaggage();

        String result = String.format(bundle.getString(PATTERN_RESULT), passengers, baggage);
        request.setAttribute(ATTRIBUTE_RESULT, result);
        return PAGE_MENU;
    }
}
