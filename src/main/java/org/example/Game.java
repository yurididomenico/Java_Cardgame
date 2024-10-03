package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    private Deck deck;
    private boolean gameEnded;

    public Game() {
        String[] values = {"A", "B", "C", "D"};
        deck = new Deck(values);
        gameEnded = false;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (!gameEnded) {

            printCards();

            int firstIndex = -1;
            int secondIndex = -1;

            while (true) {
                try {
                    System.out.print("Seleziona la prima carta (0, " + (deck.getSize() - 1) + "): ");
                    firstIndex = scanner.nextInt();
                    break; // Esce dal ciclo se l'input è valido
                } catch (InputMismatchException e) {
                    System.out.println("Input non valido! Inserisci un numero.");
                    scanner.next(); // Pulisce l'input non valido
                }
            }

            while (true) {
                try {
                    System.out.print("Seleziona la seconda carta (0, " + (deck.getSize() - 1) + "): ");
                    secondIndex = scanner.nextInt();
                    break; // Esce dal ciclo se l'input è valido
                } catch (InputMismatchException e) {
                    System.out.println("Input non valido! Inserisci un numero.");
                    scanner.next(); // Pulisce l'input non valido
                }
            }

            System.out.println();

            if (firstIndex >= 0 && firstIndex < deck.getSize() && secondIndex >= 0 && secondIndex < deck.getSize() && firstIndex != secondIndex) {
                Card firstCard = deck.drawCard(firstIndex);
                Card secondCard = deck.drawCard(secondIndex);

                // Verifica se le carte selezionate sono già abbinate
                if (firstCard.isMatched() || secondCard.isMatched()) {
                    System.out.println(underline("Una o entrambe le carte sono già abbinate. Scegli altre carte."));
                } else {
                    System.out.println("Prima carta: " + firstCard.reveal());
                    System.out.println("Seconda carta: " + secondCard.reveal());
                    System.out.println();

                    if (firstCard.getValue().equals(secondCard.getValue())) {
                        System.out.println(underline("Match trovato!"));
                        firstCard.setMatched(true);
                        secondCard.setMatched(true);
                    } else {
                        System.out.println(underline("Nessuna corrispondenza. Prova di nuovo."));
                    }
                }

                checkGameEnded();
            } else {
                System.out.println(underline("Numeri inseriti non validi. Prova di nuovo."));
            }
        }
        System.out.println(underline("Fine Gioco!"));
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

    public static String underline(String message) {
        return message + "\n" +
                "-".repeat(message.length());
    }
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}






















