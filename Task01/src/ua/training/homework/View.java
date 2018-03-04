package ua.training.homework;

public class View {
    public static final String INPUT_WORD = "Input \"%s\": %n";
    public static final String WRONG_INPUT_DATA = "Wrong input! Input should be \"%s\". Repeat please.%n";

    public void printMessage(String message) {
        System.out.println(message);
    }
    public void printMessage(String message, String properWord) {
        System.out.printf(message, properWord);
    }
}
