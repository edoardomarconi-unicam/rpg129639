package it.unicam.rpg.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.List;

public class PauseMenu extends StackPane{
    private Runnable onSaveGame = () -> {};
    private Runnable onSettings = () -> {};
    private Runnable onMainMenu = () -> {};
    private Label pauseMessage;

    public void setOnSaveGame(Runnable onSaveGame) { this.onSaveGame = onSaveGame; }
    public void setOnSettings(Runnable onSettings) { this.onSettings = onSettings; }
    public void setOnMainMenu(Runnable onMainMenu) { this.onMainMenu = onMainMenu; }

    public PauseMenu() {
        //titolo
        Label title = new Label("Pausa");
        title.setTextFill(Color.WHITE);
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 28px;");

        //bottoni
        Button resumeButton = new Button("Riprendi");
        resumeButton.setOnAction(e -> closePauseMenu());

        Button saveButton = new Button("Salva partita");
        saveButton.setOnAction(e -> onSaveGame.run());

        Button settingsButton = new Button("Impostazioni");
        settingsButton.setOnAction(e -> onSettings.run());

        Button mainMenuButton = new Button("Menù principale");
        mainMenuButton.setOnAction(e -> onMainMenu.run());

        VBox options = new VBox(12, resumeButton, saveButton, settingsButton, mainMenuButton);
        options.setAlignment(Pos.CENTER);
        for (Button button : List.of(resumeButton, saveButton, settingsButton, mainMenuButton)) {
            button.setMaxWidth(Double.MAX_VALUE);
            button.setStyle("-fx-font-size: 16px; -fx-padding: 10 20;");
        }

        //messaggio di conferma (es. "Partita salvata"), vuoto all'inizio
        pauseMessage = new Label();
        pauseMessage.setTextFill(Color.LIGHTGREEN);

        //riquadro centrale
        VBox panel = new VBox(25, title, options, pauseMessage);
        panel.setAlignment(Pos.CENTER);
        panel.setPadding(new Insets(30));
        panel.setMaxSize(320, Region.USE_PREF_SIZE);    //non si allarga a tutta la finestra
        panel.setStyle("-fx-background-color: #2d2d29; -fx-background-radius: 15;");

        //sfondo scuro semitrasparente che copre tutta la partita
        this.setStyle("-fx-background-color: rgba(0, 0, 0, 0.6);");
        this.setVisible(false);
    }

    public void openPauseMenu() {
        pauseMessage.setText("");
        this.setVisible(true);
    }

    public void closePauseMenu() {
        this.setVisible(false);
    }

    //il controller lo chiama dopo il salvataggio per dare un riscontro
    public void showPauseMessage(String message) {
        pauseMessage.setText(message);
    }
}
