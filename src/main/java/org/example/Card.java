package org.example;

public class Card {
    private String value;
    private boolean isMatched;

    public Card(String value) {
        this.value = value;
        this.isMatched = false;
    }

    public String getValue() {
        return value;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    public String reveal() {
        return value;
    }

    @Override
    public String toString() {
        return isMatched ? value : "*";
    }
}
