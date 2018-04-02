package ua.training.homework.controller.commands;

import ua.training.homework.model.services.PassengerTrainService;

import javax.servlet.http.HttpServletRequest;

/**
 * Максим
 * 31.03.2018
 */
public class Sorting implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        PassengerTrainService service = new PassengerTrainService();
        service.sortWagonsByComfortLevel();
        request.setAttribute("train", PassengerTrainService.model.getTrain().drawTrain());
        return "/WEB-INF/view/menu.jsp";
    }
}
