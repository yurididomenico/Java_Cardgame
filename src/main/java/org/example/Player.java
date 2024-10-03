package org.example;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public void drawCard(Deck deck) {
        Card card = deck.draw();

        if (card != null) {
            hand.add(card);
        }
    }

    public void showHand() {
        System.out.println(name + " ha le seguenti carte:");
        for (Card card : hand) {
            System.out.println(card);
        }
    }

    public String getName() {
        return name;
    }
}
