package org.example;


import static org.example.Main.cornice;
import static org.example.Main.pausa;

public class Game {
    private Player player1;
    private Player player2;
    private Dice dice;
    private int rounds;

    public Game(String player1, String player2, int rounds) {
        this.player1 = new Player(player1);
        this.player2 = new Player(player2);
        dice = new Dice();
        this.rounds = rounds;
    }

    public void play() {
        for (int i = 1; i <= rounds; i++) {
            pausa(4);

            System.out.println(cornice("Turno " + i));

            int roll1 = dice.roll();
            System.out.println("🎲 " + player1.getName() + " ha tirato " + roll1);
            player1.addPoints(roll1);

            int roll2 = dice.roll();
            System.out.println("🎲 " + player2.getName() + " ha tirato " + roll2);
            player2.addPoints(roll2);

            System.out.println();
        }

        pausa(5);

        System.out.println(cornice("Punteggio finale."));
        System.out.println(player1.getName() + ": " + player1.getScore());
        System.out.println(player2.getName() + ": " + player2.getScore());
        System.out.println();

        pausa(1);

        if (player1.getScore() > player2.getScore()) {
            System.out.println(player1.getName() + " vince! 🎉🎉🎊🎊🥳🥳");
        } else if (player1.getScore() < player2.getScore()) {
            System.out.println(player2.getName() + " vince! 🎉🎉🎊🎊🥳🥳");
        } else {
            System.out.println("Pareggio!");
        }
    }
}
