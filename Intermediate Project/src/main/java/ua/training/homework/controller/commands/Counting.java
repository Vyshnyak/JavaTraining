package ua.training.homework.controller.commands;

import ua.training.homework.model.services.PassengerTrainService;

import javax.servlet.http.HttpServletRequest;

/**
 * Максим
 * 31.03.2018
 */
public class Counting implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        PassengerTrainService service = new PassengerTrainService();
        int passengers = service.countPassengers();
        int baggage = service.countBaggage();
        String result = String.format("Passengers: %d, baggage: %d", passengers, baggage);
        request.setAttribute("train", PassengerTrainService.model.getTrain().drawTrain());
        request.setAttribute("result", result);
        return "/WEB-INF/view/menu.jsp";
    }
}
