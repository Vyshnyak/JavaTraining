package ua.training.homework.controller;

import ua.training.homework.model.Model;
import ua.training.homework.view.Constants;
import ua.training.homework.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The mediator between the View an Model. It gets the commands from
 * view, processes these commands and changes the model using CRUD system
 */
public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Processes the users actions in the main menu of the program.
     * It sets the language for the program's interface, then it gets
     * the action from user and calls the corresponding methods on the
     * controller service object (@code UtilController).
     *
     * @throws CloneNotSupportedException
     *         if cloning is not supported
     *
     * @throws IOException
     *         if input stream was lost
     */
    public void processUser() throws CloneNotSupportedException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        UtilController utility = new UtilController(view, model, reader);
        view.setLanguage(utility.inputString(Constants.INPUT_LANGUAGE, RegExp.LANGUAGE));
        boolean isExitEntered = false;
        while (!isExitEntered) {
            view.printMenu(View.bundle.getString(Constants.MAIN_MENU), String.format(
                    View.bundle.getString(Constants.MAIN_TITLE), model.size()));
            int action = utility.inputMenuNumber(
                    View.bundle.getString(Constants.INPUT_ACTION), Constants.MAIN_MENU_BORDER);
            switch (action) {
                case Constants.CREATE:
                    utility.createNote();
                    break;
                case Constants.READ:
                    utility.readNote();
                    break;
                case Constants.UPDATE:
                    utility.updateNote();
                    break;
                case Constants.DELETE:
                    utility.deleteNote();
                    break;
                case Constants.EXIT_BUTTON:
                    isExitEntered = true;
                    break;
            }
        }
    }
}
