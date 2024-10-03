package org.example;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Player player1 = new Player("Yuri");
        Player player2 = new Player("Ludovica");

        for (int i = 0; i < 5; i++) {
            player1.drawCard(deck);
            player2.drawCard(deck);
        }

        player1.showHand();
        System.out.println("-----");
        player2.showHand();
    }
}