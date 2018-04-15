package ua.training.homework.constants;

/**
 * Максим
 * 02.04.2018
 */
public interface TextConstants {
    String COMMAND_BUILD = "/build";
    String COMMAND_FILL = "/fill";
    String COMMAND_COUNT = "/count";
    String COMMAND_SORT = "/sort";
    String COMMAND_SEARCH = "/search";
    String COMMAND_LANGUAGE = "/language";

    String PARAMETER_START = "start";
    String PARAMETER_END = "end";
    String PARAMETER_LOCALE = "locale";
    String PARAMETER_PAGE_NAME = "pageName";

    String ATTRIBUTE_TRAIN = "train";
    String ATTRIBUTE_MESSAGE_RESULT = "result";
    String ATTRIBUTE_COUNT_RESULT = "countResult";
    String ATTRIBUTE_SEARCH_RESULT = "searchResult";
    String ATTRIBUTE_PASSENGERS = "passengers";
    String ATTRIBUTE_BAGGAGE = "baggage";
    String ATTRIBUTE_TRAIN_TYPE = "trainType";
    String ATTRIBUTE_LANGUAGE = "language";

    String MESSAGE_WAGONS_NOT_FOUND = "message.wagons.not.found";
    String MESSAGE_WRONG_INPUT_FORMAT = "message.wrong.input.format";

    String PATTERN_RESULT = "pattern.result";
    String PASSENGER_TRAIN_TITLE = "passenger.train";

    String PAGE_MENU = "/WEB-INF/view/menu.jsp";
}
