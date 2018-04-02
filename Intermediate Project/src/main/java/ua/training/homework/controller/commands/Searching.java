package ua.training.homework.controller.commands;

import ua.training.homework.model.entity.wagons.Wagon;
import ua.training.homework.model.services.PassengerTrainService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Максим
 * 31.03.2018
 */
public class Searching implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        PassengerTrainService service = new PassengerTrainService();
        int offset = Integer.parseInt(request.getParameter("offset"));
        int end = Integer.parseInt(request.getParameter("end"));
        try {
            List<Wagon> wagons = service.findWagonsWithPassengersAmountRange(offset, end);
            request.setAttribute("result", wagons);
        } catch (NoSuchElementException e) {
            request.setAttribute("result", "There is no wagons with passengers amount in that range!");
        }
        request.setAttribute("train", PassengerTrainService.model.getTrain().drawTrain());
        return "/WEB-INF/view/menu.jsp";
    }
}
