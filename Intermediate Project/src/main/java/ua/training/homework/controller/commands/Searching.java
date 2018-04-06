package ua.training.homework.controller.commands;

import ua.training.homework.model.entity.wagons.PassengerWagon;
import ua.training.homework.model.services.PassengerTrainService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

import static ua.training.homework.controller.constants.Constants.*;

/**
 * Максим
 * 31.03.2018
 */
public class Searching implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        PassengerTrainService service = new PassengerTrainService();
        int start = Integer.parseInt(request.getParameter(PARAMETER_START));
        int end = Integer.parseInt(request.getParameter(PARAMETER_END));
        ResourceBundle bundle = ResourceBundle.getBundle(BASE_NAME,
                new Locale((String) request.getSession().getAttribute(ATTRIBUTE_LANGUAGE)));
        try {
            List<PassengerWagon> wagons = service.findWagonsWithPassengersAmountRange(start, end);
            request.setAttribute(ATTRIBUTE_RESULT, wagons);
        } catch (NoSuchElementException e) {
            request.setAttribute(ATTRIBUTE_RESULT, bundle.getString(MESSAGE_WAGONS_NOT_FOUND));
        }
        return PAGE_MENU;
    }
}
