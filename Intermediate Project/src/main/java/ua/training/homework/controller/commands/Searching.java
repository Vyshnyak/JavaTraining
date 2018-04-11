package ua.training.homework.controller.commands;

import ua.training.homework.controller.util.ControllerUtil;
import ua.training.homework.model.entity.PassengerWagon;
import ua.training.homework.model.services.PassengerTrainService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static ua.training.homework.constants.TextConstants.*;

/**
 * Максим
 * 31.03.2018
 */
public class Searching implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        try {
            ControllerUtil.checkRangeInputFormat(request);
            PassengerTrainService service = new PassengerTrainService();
            int start = Integer.parseInt(request.getParameter(PARAMETER_START));
            int end = Integer.parseInt(request.getParameter(PARAMETER_END));
            List<PassengerWagon> wagons = service.findWagonsWithPassengersAmountRange(start, end);
            if (!wagons.isEmpty()) {
                request.setAttribute(ATTRIBUTE_SEARCH_RESULT, wagons);
            } else {
                request.setAttribute(ATTRIBUTE_MESSAGE_RESULT, MESSAGE_WAGONS_NOT_FOUND);
            }
        } catch (IllegalArgumentException e) {
            request.setAttribute(ATTRIBUTE_MESSAGE_RESULT, MESSAGE_WRONG_INPUT_FORMAT);
        }
        return PAGE_MENU;
    }
}
