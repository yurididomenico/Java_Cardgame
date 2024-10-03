package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("YDD Games");
        System.out.println("Gioco dei Dadi\n\n");

        Game game = new Game("Ludovica", "Yuri", 3);
        game.play();

    }

    public static String cornice(String messaggio) {
        return "-".repeat(messaggio.length() + messaggio.length()) + "\n" +
                " ".repeat(messaggio.length() / 2) +messaggio + "\n" +
                "-".repeat(messaggio.length() + messaggio.length());
    }

    public static void pausa(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}