package ua.training.homework.view;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Part of the MVC patter that is used to interact with user
 * by showing him information and receiving commands from him
 */
public class View {
    public static ResourceBundle bundle =
            ResourceBundle.getBundle(Constants.MESSAGES_BUNDLE_NAME);

    /**
     * Prints message to the console
     *
     * @param  message  a message to be printed on the console
     */
    public void printMessage(String message){
        System.out.println(message);
    }

    /**
     * Prints message to the console asking user for input
     *
     * @param  message  a message to be printed on the console
     */
    public void printInputMessage(String message) {
        System.out.print(message);
    }

    /**
     * Builds a menu from an array of strings using a (@code StringBuilder)
     * object and returns a string that represents a menu
     *
     * @param  strings  the array of strings to build a menu of
     *
     * @return          the string that represents a menu
     */
    public static String menuBuilder(String... strings) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = Constants.ZERO;
        for (String string: strings) {
            stringBuilder.append(String.format(Constants.NUMERATION_FORMAT, ++count));
            stringBuilder.append(Constants.DOT);
            stringBuilder.append(Constants.SPACE);
            stringBuilder.append(string);
            stringBuilder.append(Constants.NEW_LINE);
        }
        return stringBuilder.toString();
    }

    /**
     * Prints a menu title
     *
     * @param  menuTitle  a menu title to be printed on the console
     */
    public void printTitle(String menuTitle) {
        printMessage(Constants.NEW_LINE + Constants.BORDER);
        printMessage(menuTitle);
        printMessage(Constants.BORDER);
    }

    /**
     * Prints menu title and menu
     *
     * @param  menu      a menu to be printed on the console
     * @param  menuTitle a menu title to be printed on the console
     */
    public void printMenu(String menu, String menuTitle) {
        printTitle(menuTitle);
        printMessage(menu);
    }

    /**
     * Asks user to choose a language of the program interface and sets
     * the chosen language
     *
     * @param  language  the language shortening that represents a chosen
     *                   language format
     */
    public void setLanguage(String language) {
        switch (language) {
            case Constants.ENGLISH:
                bundle = ResourceBundle.getBundle(Constants.MESSAGES_BUNDLE_NAME);
                break;
            case Constants.UKRAINIAN:
                bundle = ResourceBundle.getBundle(Constants.MESSAGES_BUNDLE_NAME,
                        new Locale(Constants.UKRAINIAN));
        }
    }
}
