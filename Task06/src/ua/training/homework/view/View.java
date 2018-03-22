package ua.training.homework.view;

import java.util.Locale;
import java.util.ResourceBundle;

import static ua.training.homework.view.Constants.INPUT_STRING_DATA;
import static ua.training.homework.view.Constants.NEW_LINE;
import static ua.training.homework.view.Constants.WRONG_INPUT_DATA;

/**
 * Максим
 * 16.03.2018
 */
public class View {
    // Resource Bundle Installation's
    static String MESSAGES_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    new Locale("ua", "UA"));  // Ukrainian
                                    //new Locale("en"));        // English

    //Utilities methods
    /**
     *
     * @param message
     */
    public void printMessage(String message){
        System.out.println(message);
    }

    /**
     *
     * @param message
     */
    public void printInputMessage(String message){
        System.out.print(message);
    }

    /**
     *
     * @param message
     * @return
     */
    public String concatenationString(String... message){
        StringBuilder concatString = new StringBuilder();
        for(String v : message) {
            concatString = concatString.append(v);
        }
        return new String(concatString);
    }

    public void printStringInput(String message) {
        printInputMessage(concatenationString(
                bundle.getString(INPUT_STRING_DATA),
                bundle.getString(message)));
    }

    public void printWrongStringInput(String message) {
        printInputMessage(concatenationString(
                bundle.getString(WRONG_INPUT_DATA),
                NEW_LINE,
                bundle.getString(INPUT_STRING_DATA),
                bundle.getString(message)));
    }
}
