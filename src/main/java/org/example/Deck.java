package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        String[] suits = {"Cuori", "Picche", "Fiori", "Quadri"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Fante", "Regina", "Re", "Asso"};

        cards = new ArrayList<>();

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }

        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(0); // Pesca la prima carta
    }
}
