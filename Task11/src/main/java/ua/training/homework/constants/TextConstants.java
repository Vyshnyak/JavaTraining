package ua.training.homework.constants;

/**
 * Максим
 * 18.03.2018
 */
public interface TextConstants {
    String COMMAND_CREATE = "/create";
    String COMMAND_READ = "/read";
    String COMMAND_UPDATE = "/update";
    String COMMAND_DELETE = "/delete";
    String COMMAND_UPDATE_FORM = "/updateForm";
    String COMMAND_UPDATE_MENU = "/updateMenu";
    String COMMAND_DELETE_MENU = "/deleteMenu";

    String PAGE_INDEX = "/index.jsp";
    String PAGE_CREATE_FORM = "/create_form.jsp";
    String PAGE_READ = "/read.jsp";
    String PAGE_DELETE_MENU = "/delete_menu.jsp";
    String PAGE_UPDATE_MENU = "/update_menu.jsp";
    String PAGE_UPDATE_FORM = "/update_form.jsp";

    String URL_DELETE_MENU = "/app/deleteMenu";
    String URL_UPDATE_MENU = "/app/updateMenu";

    String MESSAGE_LOGIN_IS_NOT_UNIQUE = "Login [%s] is already taken! Please choose another login!";
    String MESSAGE_WRONG_DATA_FORMAT = "Your data doesn't match pattern";

    String ATTRIBUTE_MESSAGE = "message";
    String ATTRIBUTE_NOTES = "notes";
    String ATTRIBUTE_NOTE = "note";

    String PARAM_FIRST_NAME = "firstName";
    String PARAM_LOGIN = "login";
    String PARAM_ID = "id";
}
