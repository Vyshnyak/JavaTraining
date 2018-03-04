package ua.training.homework;

public class Model {
    private String statement;

    public void setStatement(String firstWord, String secondWord) {
        this.statement = firstWord + ", " + secondWord;
    }

    public String getStatement() {
        return statement;
    }
}
