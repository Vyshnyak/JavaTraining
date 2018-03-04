package ua.training.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {
    public static final String PROPER_FIRST_WORD = "Hello";
    public static final String PROPER_SECOND_WORD = "world!";

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String firstWord = getWord(reader, PROPER_FIRST_WORD);
            String secondWord = getWord(reader, PROPER_SECOND_WORD);
            model.setStatement(firstWord, secondWord);
        }
        view.printMessage(model.getStatement());
    }

    private String getWord(BufferedReader reader, String properWord) throws IOException {
        view.printMessage(View.INPUT_WORD, properWord);
        String word;
        while (!(word = reader.readLine()).equals(properWord)) {
            view.printMessage(View.WRONG_INPUT_DATA, properWord);
        }
        return word;
    }
}
