package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck(String[] values) {
        cards = new ArrayList<>();

        for (String value : values) {
            cards.add(new Card(value));
            cards.add(new Card(value));
        }

        Collections.shuffle(cards);
    }

    public Card drawCard(int index) {
        return cards.get(index);
    }

    public int getSize() {
        return cards.size();
    }
}
