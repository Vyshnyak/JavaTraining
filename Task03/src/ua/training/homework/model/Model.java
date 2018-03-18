package ua.training.homework.model;

import ua.training.homework.model.entity.Note;
import ua.training.homework.view.View;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Contains all the information that users works with and all
 * it's business logic
 */
public class Model {
    private List<Note> notes = new ArrayList<>();

    /**
     * Checks whether the list of notes is empty and returns
     * the corresponding boolean result
     *
     * @return  true whether list is empty or false if it's not
     */
    public boolean isEmpty() {
        return notes.isEmpty();
    }

    /**
     * Returns the size of the note's list
     *
     * @return  size of the list represented as int
     */
    public int size() {
        return notes.size();
    }

    /**
     * Replaces the old note with a new one
     *
     * @param  index  an index of the note in the list that will be replaced
     *
     * @param  note   the note that replaces the old note
     */
    public void setNote(int index, Note note) {
        notes.set(--index, note);
    }

    /**
     * Returns the note from the list at the given index
     *
     * @param  index  an index of the note in the list that will be returned
     *
     * @return        the note that locates in list under the given index
     *
     * @throws CloneNotSupportedException
     *         if cloning is not supported
     */
    public Note getNote(int index) throws CloneNotSupportedException {
        return notes.get(--index).clone();
    }

    /**
     * Adds a new note to the list of notes
     *
     * @param  note  a new note to be placed in a list
     */
    public void addNote(Note note) {
        notes.add(note);
        notes.sort(Comparator.comparing(Note::getFullName));
    }

    /**
     * Removes the note from the list at the given index
     *
     * @param  index  an index of note to be removed from the list
     */
    public void removeNote(int index) {
        notes.remove(--index);
        notes.sort(Comparator.comparing(Note::getFullName));
    }

    /**
     * Returns a string represented as a menu of notes that was built
     * from all the available notes in the list
     *
     * @return  string that is represented as a menu list of notes
     */
    public String getNotesMenu() {
        return View.menuBuilder(notes.stream()
                .map(Note::getFullName)
                .toArray(String[]::new));
    }
}
