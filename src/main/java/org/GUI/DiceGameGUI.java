package org.GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.Dice;
import org.example.Player;

public class DiceGameGUI extends Application {
    private Label resultLabel;
    private Button rollButton;
    private Button startButton; // Pulsante per iniziare il gioco
    private TextField roundInput; // Campo di input per il numero di round
    private Player player1;
    private Player player2;
    private Dice dice;
    private int round;
    private int totalRounds;
    private boolean gameInProgress; // Stato del gioco

    @Override
    public void start(Stage primaryStage) {
        // Inizializza i giocatori e il dado
        player1 = new Player("Ludovica");
        player2 = new Player("Yuri");
        dice = new Dice();
        round = 1;
        gameInProgress = false; // Imposta lo stato del gioco a falso

        // Crea gli elementi dell'interfaccia
        resultLabel = new Label("Inserisci il numero di round e premi 'Inizia' per iniziare");
        roundInput = new TextField();
        roundInput.setPromptText("Numero di round");

        startButton = new Button("Inizia");
        startButton.setOnAction(e -> startGame());

        rollButton = new Button("Lancia i Dadi");
        rollButton.setDisable(true); // Disabilita il pulsante fino all'inizio del gioco
        rollButton.setOnAction(e -> playRound());

        // Layout dell'interfaccia
        VBox layout = new VBox(10);
        layout.getChildren().addAll(resultLabel, roundInput, startButton, rollButton);
        layout.setStyle("-fx-background-color: #f0f0f0;"); // Sfondo grigio chiaro

        // Aggiunta di stili CSS
        rollButton.setStyle("-fx-background-color: #007bff; -fx-text-fill: white;"); // Pulsante blu
        startButton.setStyle("-fx-background-color: #28a745; -fx-text-fill: white;"); // Pulsante verde
        resultLabel.setStyle("-fx-text-fill: #2e2e2e;"); // Testo grigio scuro

        // Crea la scena e mostra il palcoscenico
        Scene scene = new Scene(layout, 600, 500);
        primaryStage.setTitle("Gioco di Dadi");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void startGame() {
        try {
            totalRounds = Integer.parseInt(roundInput.getText());
            if (totalRounds <= 0) {
                resultLabel.setText("Inserisci un numero di round valido (maggiore di 0).");
                return; // Non proseguire se il numero non è valido
            }
            round = 1; // Reset dei round
            gameInProgress = true; // Inizia il gioco
            resultLabel.setText("Premi 'Lancia i Dadi' per iniziare");
            rollButton.setDisable(false); // Abilita il pulsante di lancio
            startButton.setVisible(false); // Nascondi il pulsante Inizia

            // Ripristina i punteggi
            player1.resetScore();
            player2.resetScore();
        } catch (NumberFormatException e) {
            resultLabel.setText("Per favore, inserisci un numero valido di round.");
        }
    }

    private void playRound() {
        if (gameInProgress && round <= totalRounds) {
            int roll1 = dice.roll();
            player1.addPoints(roll1);

            int roll2 = dice.roll();
            player2.addPoints(roll2);

            // Risultati
            resultLabel.setText("Turno " + round + "\n" +
                    player1.getName() + " tira: " + roll1 + "\n" +
                    player2.getName() + " tira: " + roll2 + "\n");

            round++;

            if (round > totalRounds) {
                showWinner();
            }
        }
    }

    private void showWinner() {
        String winner;

        if (player1.getScore() > player2.getScore()) {
            winner = player1.getName() + " vince!";
        } else if (player1.getScore() < player2.getScore()) {
            winner = player2.getName() + " vince!";
        } else {
            winner = "Pareggio";
        }

        resultLabel.setText(resultLabel.getText() +
                "\n\nPunteggio finale:\n" +
                player1.getName() + ": " + player1.getScore() + "\n" +
                player2.getName() + ": " + player2.getScore() + "\n" +
                winner);

        // Cambia il testo del pulsante in "Rigioca"
        rollButton.setText("Rigioca");
        rollButton.setOnAction(e -> resetGame());
        gameInProgress = false; // Imposta il gioco come non in corso
    }

    private void resetGame() {
        // Ripristina solo i punteggi
        player1.resetScore();
        player2.resetScore();
        round = 1;

        // Ripristina l'interfaccia
        resultLabel.setText("Inserisci il numero di round e premi 'Inizia' per iniziare");
        roundInput.clear();
        rollButton.setText("Lancia i Dadi");
        rollButton.setDisable(true); // Disabilita il pulsante fino a che non inizia un nuovo gioco

        // Mostra di nuovo il pulsante Inizia
        startButton.setVisible(true); // Mostra il pulsante di avvio
    }

    public static void main(String[] args) {
        launch(args);
    }
}
