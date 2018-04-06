package ua.training.homework.controller.constants;

/**
 * Максим
 * 02.04.2018
 */
public interface Constants {
    String BASE_NAME = "messages";

    String COMMAND_BUILDING = "building";
    String COMMAND_FILLING = "filling";
    String COMMAND_COUNTING = "counting";
    String COMMAND_SORTING = "sorting";
    String COMMAND_SEARCHING = "searching";
    String COMMAND_LANGUAGE = "language";

    String PAGE_MENU = "/WEB-INF/view/menu.jsp";
    String PAGE_INDEX = "/";

    String PARAMETER_START = "start";
    String PARAMETER_END = "end";
    String PARAMETER_LOCALE = "locale";

    String ATTRIBUTE_TRAIN = "train";
    String ATTRIBUTE_RESULT = "result";
    String ATTRIBUTE_TRAIN_TYPE = "trainType";
    String ATTRIBUTE_LANGUAGE = "language";
    String ATTRIBUTE_PAGE = "page";
    String ATTRIBUTE_COMMAND = "command";

    String ALL_BEFORE_COMMAND = ".*/app/";
    String EMPTY_LINE = "";

    String COMMAND_BUILD = "command.build";
    String COMMAND_FILL = "command.fill";
    String COMMAND_COUNT = "command.count";
    String COMMAND_SORT = "command.sort";
    String COMMAND_SEARCH = "command.search";
    String COMMAND_SET_LANGUAGE = "command.set.language";

    String MAIN_PAGE_TITLE = "main.page.title";

    String PASSENGER_TRAIN_TITLE = "passenger.train";

    String MESSAGE_FILL = "message.command.fill";
    String MESSAGE_COUNT = "message.command.count";
    String MESSAGE_SORT = "message.command.sort";
    String MESSAGE_SEARCH = "message.command.search";

    String MESSAGE_WAGONS_NOT_FOUND = "message.wagons.not.found";
    String MESSAGE_WRONG_INPUT_FORMAT = "message.wrong.input.format";
    String PATTERN_RESULT = "pattern.result";
}
