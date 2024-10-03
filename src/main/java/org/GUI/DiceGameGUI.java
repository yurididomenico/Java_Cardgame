package org.GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.Dice;
import org.example.Player;

public class DiceGameGUI extends Application {
    private Label resultLabel;
    private Player player1;
    private Player player2;
    private Dice dice;
    private int round;
    private int totalRounds;

    @Override
    public void start(Stage primaryStage) {
        // Init
        player1 = new Player("Ludovica");
        player2 = new Player("Yuri");
        dice = new Dice();
        round = 1;
        totalRounds = 3;

        // GUI: Elementi
        resultLabel = new Label("Premi 'Lancia i Dadi' per iniziare");
        Button rollButton = new Button("Lancia i Dadi");
        rollButton.setOnAction(e -> playRound());

        // GUI: Layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(resultLabel, rollButton);
        layout.setStyle("-fx-background-color: #f0f0f0;");

        // Style
        rollButton.setStyle("-fx-background-color: #007bff; -fx-text-fill: white;");
        resultLabel.setStyle("-fx-text-fill: #2e2e2e;");

        // Scene
        Scene scene = new Scene(layout, 600, 500);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        primaryStage.setTitle("Gioco di Dadi");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void playRound() {
        if (round <= totalRounds) {
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
    }

    public static void main(String[] args) {
        launch(args);
    }
}























