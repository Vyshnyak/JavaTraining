package ua.training.homework;

public class View {
    public static final String INPUT_NUMBER = "Input number in range ";
    public static final String ENTERED_NUMBER = "Your number is ";
    public static final String TARGET_NUMBER = "Target number is ";
    public static final String WRONG_INPUT = "Wrong input! Input number!";
    public static final String OUT_OF_RANGE = "Wrong input! Number should be in range ";
    public static final String WIN = "Congratulations you have won! The target number was ";
    public static final String STATISTIC = "Your action statistic:\n";

    public void printMessage(String message) {
        System.out.println(message);
    }
}
