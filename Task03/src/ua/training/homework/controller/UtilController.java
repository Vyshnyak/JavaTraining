package ua.training.homework.controller;

import ua.training.homework.bean.Address;
import ua.training.homework.bean.Group;
import ua.training.homework.bean.Note;
import ua.training.homework.model.Model;
import ua.training.homework.view.Constants;
import ua.training.homework.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;

/**
 * Controller service object that helps controller to process
 * user's inputs and doing corresponding actions with notebook
 * such as creating, reading, updating, deleting notes.
 */
public class UtilController {
    private View view;
    private Model model;

    private BufferedReader reader;

    public UtilController(View view, Model model, BufferedReader reader) {
        this.view = view;
        this.model = model;
        this.reader = reader;
    }

    /**
     * Gets input data from user via console, checks it using a given
     * regular expression and returns an appropriate data.
     *
     * @param  message  the message to be shown to user before asking
     *                  for input
     *
     * @param  regex    the regular expression which is used to
     *                  check the correctness of the user's input
     *
     * @return          the string represented as the user's input
     *                  from the console
     *
     * @throws IOException
     *         If an I/O error occurs
     */
    String inputString(String message, String regex) throws IOException {
        String result;
        view.printInputMessage(message);
        while (!((result = reader.readLine()) != null && result.matches(regex))) {
            view.printMessage(View.bundle.getString(Constants.WRONG_INPUT));
            view.printInputMessage(message);
        }
        return result;
    }

    /**
     * Gets index number input from user via console, checks it using a given
     * range and returns an appropriate index number.
     *
     * @param  message  the message to be shown to user before asking
     *                  for input
     *
     * @param  border   the last possible index of the menu elements
     *                  that can be used to access the element
     *
     * @return          the index number represented as the user's input
     *                  from the console
     *
     * @throws IOException
     *         If an I/O error occurs
     */
    int inputMenuNumber(String message, int border) throws IOException {
        int result;
        view.printInputMessage(message);
        while (true) {
            try {
                result = Integer.parseInt(reader.readLine());
                if (result >= Constants.ZERO && result <= border) {
                    break;
                } else {
                    view.printMessage(View.bundle.getString(Constants.WRONG_INPUT));
                    view.printInputMessage(message);
                }
            } catch (NumberFormatException e) {
                view.printMessage(View.bundle.getString(Constants.WRONG_INPUT));
                view.printInputMessage(message);
            }
        }
        return result;
    }

    /**
     * Prints notes menu and gets a conditional input from user.
     * If the notes list is empty it asks user to input exit button
     * and if it's not empty, it asks the user to input a note index
     * via inputMenuNumber method and returns an appropriate note index.
     *
     * @param  menuType  the type of the menu to be shown before user's
     *                   input
     *
     * @return           the index number represented as the user's
     *                   input from the console
     *
     * @throws IOException
     *         If an I/O error occurs
     */
    private int inputNoteNumber(String menuType) throws IOException {
        view.printMenu(model.getNotesMenu(),
                String.format(menuType, model.size()));
        return model.isEmpty() ?
                inputMenuNumber(View.bundle.getString(Constants.INPUT_EXIT), Constants.EXIT_BUTTON) :
                inputMenuNumber(View.bundle.getString(Constants.INPUT_NOTE), model.size());
    }

    /**
     * Creates a new note and adds it to the notebook model.
     *
     * @throws IOException
     *         if input stream was lost
     */
    void createNote() throws IOException {
        view.printTitle(String.format(
                View.bundle.getString(Constants.CREATE_TITLE), model.size()));

        model.addNote(new Note(
                inputString(View.bundle.getString(Constants.LAST_NAME), RegExp.LAST_NAME),
                inputString(View.bundle.getString(Constants.FIRST_NAME), RegExp.FIRST_NAME),
                inputString(View.bundle.getString(Constants.MIDDLE_NAME), RegExp.MIDDLE_NAME),
                inputString(View.bundle.getString(Constants.NICKNAME), RegExp.NICKNAME),
                inputString(View.bundle.getString(Constants.COMMENT), RegExp.COMMENT),
                Group.valueOf(inputString(View.bundle.getString(Constants.GROUP), RegExp.GROUP)),
                inputString(View.bundle.getString(Constants.HOME_PHONE), RegExp.HOME_PHONE),
                inputString(View.bundle.getString(Constants.CELL_PHONE_ONE), RegExp.CELL_PHONE_ONE),
                inputString(View.bundle.getString(Constants.CELL_PHONE_TWO), RegExp.SECOND_CELL_TWO),
                inputString(View.bundle.getString(Constants.EMAIL), RegExp.EMAIL),
                inputString(View.bundle.getString(Constants.SKYPE), RegExp.SKYPE),
                new Address(inputString(View.bundle.getString(Constants.INDEX), RegExp.INDEX),
                        inputString(View.bundle.getString(Constants.CITY), RegExp.CITY),
                        inputString(View.bundle.getString(Constants.STREET), RegExp.STREET),
                        inputString(View.bundle.getString(Constants.HOUSE), RegExp.HOUSE),
                        inputString(View.bundle.getString(Constants.APARTMENT), RegExp.APARTMENT))));
    }

    /**
     * Gets the element reading menu from note object and shows it to user.
     *
     * @throws CloneNotSupportedException
     *         if cloning is not supported
     *
     * @throws IOException
     *         If an I/O error occurs
     */
    void readNote() throws CloneNotSupportedException, IOException {
        int noteNumber;
        while (!((noteNumber = inputNoteNumber(
                View.bundle.getString(Constants.READ_TITLE))) == Constants.EXIT_BUTTON)) {

            Note note = model.getNote(noteNumber);
            view.printMenu(note.getReadElementMenu(), String.format(
                    View.bundle.getString(Constants.READ_TITLE), model.size()));

            while (!(inputMenuNumber(
                    View.bundle.getString(Constants.INPUT_EXIT), Constants.EXIT_BUTTON)
                    == Constants.EXIT_BUTTON)) ;
        }
    }

    /**
     * Updates note which user entered index of. Asks user for input
     * until he entered an exit button. If there were changes when
     * exit button was pressed it asks user whether he wants to
     * save changes or no.
     *
     * @throws CloneNotSupportedException
     *         if cloning is not supported
     *
     * @throws IOException
     *         If an I/O error occurs
     */
    void updateNote() throws CloneNotSupportedException, IOException {
        int noteNumber;
        while (!((noteNumber = inputNoteNumber(
                View.bundle.getString(Constants.UPDATE_TITLE))) == Constants.EXIT_BUTTON)) {

            Note note = model.getNote(noteNumber);
            boolean isUpdated = false;
            while (true) {
                view.printMenu(note.getUpdateElementMenu(), String.format(
                        View.bundle.getString(Constants.UPDATE_TITLE), model.size()));

                int elementIndex = inputMenuNumber(
                        View.bundle.getString(Constants.INPUT_ELEMENT), Constants.ELEMENT_MENU_BORDER);

                if (elementIndex == Constants.EXIT_BUTTON) {
                    if (isUpdated && isConfirmed(Constants.CONFIRM_SAVE)) {
                        model.setNote(noteNumber, note);
                    }
                    break;
                }
                switch (elementIndex) {
                    case Constants.LAST_NAME_INDEX:
                        note.setLastName(inputString(
                                View.bundle.getString(Constants.LAST_NAME), RegExp.LAST_NAME));
                        note.setFullName();
                        break;
                    case Constants.FIRST_NAME_INDEX:
                        note.setFirstName(inputString(
                                View.bundle.getString(Constants.FIRST_NAME), RegExp.FIRST_NAME));
                        note.setFullName();
                        break;
                    case Constants.MIDDLE_NAME_INDEX:
                        note.setMiddleName(inputString(
                                View.bundle.getString(Constants.MIDDLE_NAME), RegExp.MIDDLE_NAME));
                        break;
                    case Constants.NICKNAME_INDEX:
                        note.setNickname(inputString(
                                View.bundle.getString(Constants.NICKNAME), RegExp.NICKNAME));
                        break;
                    case Constants.COMMENT_INDEX:
                        note.setComment(inputString(
                                View.bundle.getString(Constants.COMMENT), RegExp.COMMENT));
                        break;
                    case Constants.GROUP_INDEX:
                        note.setGroup(Group.valueOf(inputString(
                                View.bundle.getString(Constants.GROUP), RegExp.GROUP)));
                        break;
                    case Constants.HOME_PHONE_INDEX:
                        note.setHomePhone(inputString(
                                View.bundle.getString(Constants.HOME_PHONE), RegExp.HOME_PHONE));
                        break;
                    case Constants.CELL_PHONE_INDEX:
                        note.setCellPhone(inputString(
                                View.bundle.getString(Constants.CELL_PHONE_ONE), RegExp.CELL_PHONE_ONE));
                        break;
                    case Constants.SECOND_CELL_PHONE_INDEX:
                        note.setSecondCellPhone(inputString(
                                View.bundle.getString(Constants.CELL_PHONE_TWO), RegExp.SECOND_CELL_TWO));
                        break;
                    case Constants.EMAIL_INDEX:
                        note.setEmail(inputString(
                                View.bundle.getString(Constants.EMAIL), RegExp.EMAIL));
                        break;
                    case Constants.SKYPE_INDEX:
                        note.setSkype(inputString(
                                View.bundle.getString(Constants.SKYPE), RegExp.SKYPE));
                        break;
                    case Constants.ADDRESS_INDEX:
                        note.setAddress(new Address(
                                inputString(View.bundle.getString(Constants.INDEX), RegExp.INDEX),
                                inputString(View.bundle.getString(Constants.CITY), RegExp.CITY),
                                inputString(View.bundle.getString(Constants.STREET), RegExp.STREET),
                                inputString(View.bundle.getString(Constants.HOUSE), RegExp.HOUSE),
                                inputString(View.bundle.getString(Constants.APARTMENT), RegExp.APARTMENT)));
                        note.setFullAddress();
                        break;
                    default:
                        view.printMessage(View.bundle.getString(Constants.WRONG_INPUT));
                        break;
                }
                isUpdated = true;
                note.setLastChangeDate(new Date());
            }
        }
    }

    /**
     * Deletes note which user entered index of.
     *
     * @throws IOException
     *         If an I/O error occurs
     */
    void deleteNote() throws IOException {
        int noteNumber;
        while (!((noteNumber = inputNoteNumber(
                View.bundle.getString(Constants.DELETE_TITLE))) == Constants.EXIT_BUTTON)) {
            if (isConfirmed(Constants.CONFIRM_DELETE)) {
                model.removeNote(noteNumber);
            }
        }
    }

    /**
     * Asks user to confirm his action by entering yes or no.
     *
     * @param  confirmation  a type of confirmation message to be shown
     *                       before the user's input
     *
     * @return               true if user's input is 'yes' or false if
     *                       it's 'no'
     *
     * @throws IOException
     *         If an I/O error occurs
     */
    private boolean isConfirmed(String confirmation) throws IOException {
        return inputString(
                View.bundle.getString(confirmation),
                View.bundle.getString(RegExp.YES_NO))
                .equals(View.bundle.getString(Constants.YES_BUTTON));
    }
}
