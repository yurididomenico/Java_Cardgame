package org.example;

import java.util.Scanner;

public class Game {

    private Deck deck;
    private boolean gameEnded;

    public Game() {
        String[] values = {"A", "B", "C", "D", "E", "F", "G", "H"};
        deck = new Deck(values);
        gameEnded = false;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (!gameEnded) {

            printCards();
            System.out.print("Seleziona la prima carta (0, " + (deck.getSize() - 1) + "): ");
            int firstIndex = scanner.nextInt();
            System.out.print("Seleziona la seconda carta (0, " + (deck.getSize() - 1) + "): ");
            int secondIndex = scanner.nextInt();

            if (firstIndex >= 0 &&
                    firstIndex < deck.getSize() &&
                    secondIndex >= 0 &&
                    secondIndex < deck.getSize() &&
                    firstIndex != secondIndex) {
                Card firstCard = deck.drawCard(firstIndex);
                Card secondCard = deck.drawCard(secondIndex);

                System.out.println("Prima carta: " + firstCard.reveal());
                System.out.println("Seconda carta: " + secondCard.reveal());

                if (firstCard.getValue().equals(secondCard.getValue())) {
                    System.out.println("Presa!");
                    firstCard.setMatched(true);
                    secondCard.setMatched(true);
                } else {
                    System.out.println("Sbagliato, riprova!");
                }

                checkGameEnded();
            } else {
                System.out.println("Numeri inseriti non validi, riprova.");
            }
        }
        System.out.println("Fine Gioco!");
        scanner.close();
    }

    public void printCards() {
        System.out.println("Carte attuali:");
        for (int i = 0; i < deck.getSize(); i++) {
            System.out.print(deck.drawCard(i) + " ");
        }
        System.out.println();
    }

    public void checkGameEnded() {
        for (int i = 0; i < deck.getSize(); i++) {
            if (!deck.drawCard(i).isMatched()) {
                return;
            }
        }
        gameEnded = true;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}






















