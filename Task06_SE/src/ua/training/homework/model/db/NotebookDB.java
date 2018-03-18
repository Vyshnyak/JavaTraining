package ua.training.homework.model.db;

/**
 * Максим
 * 16.03.2018
 */
public enum NotebookDB {
    NOTE_ONE("Макс", "Dentris"),
    NOTE_TWO("Игорь", "Mongolski"),
    NOTE_THREE("Юрий", "Resius"),
    NOTE_FOUR("Наташа", "Fresa");

    private String firstName;
    private String login;

    NotebookDB(String firstName, String login) {
        this.firstName = firstName;
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public static boolean containsLogin(String login) {
        for (NotebookDB note : NotebookDB.values()) {
            if (note.login.equals(login)) {
                return true;
            }
        }
        return false;
    }
}
