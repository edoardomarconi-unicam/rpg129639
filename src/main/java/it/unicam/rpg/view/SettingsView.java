package it.unicam.rpg.view;

import it.unicam.rpg.model.settings.Difficulty;
import it.unicam.rpg.persistence.SettingsLoaderSaver;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class SettingsView extends StackPane {
    private Consumer<Difficulty> onDifficultyChanged = difficulty -> {};
    private Runnable onDeleteSaves = () -> {};
    private Runnable onBack = () -> {};

    private final ComboBox<Difficulty> difficultyBox;
    private final Label settingsMessage;

    public void setOnDifficultyChanged(Consumer<Difficulty> onDifficultyChanged) { this.onDifficultyChanged = onDifficultyChanged; }
    public void setOnDeleteSaves(Runnable onDeleteSaves) { this.onDeleteSaves = onDeleteSaves; }
    public void setOnBack(Runnable onBack) { this.onBack = onBack; }

    public SettingsView() {
        //titolo
        Label title = new Label("Impostazioni");
        title.setTextFill(Color.WHITE);
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 28px;");

        //difficoltà
        Label difficultyLabel = new Label("Difficoltà");
        difficultyLabel.setTextFill(Color.WHITE);
        difficultyLabel.setStyle("-fx-font-size: 16px;");

        difficultyBox = new ComboBox<>();
        difficultyBox.getItems().addAll(Difficulty.values());
        difficultyBox.setValue(new SettingsLoaderSaver().load().getDifficulty());
        difficultyBox.setMaxWidth(Double.MAX_VALUE);
        difficultyBox.setStyle("-fx-font-size: 16px;");
        difficultyBox.setOnAction(e -> {
            Difficulty selected = difficultyBox.getValue();
            if (selected != null) onDifficultyChanged.accept(selected);
        });

        VBox difficultySection = new VBox(6, difficultyLabel, difficultyBox);

        //cancellazione salvataggi
        Button deleteSavesButton = new Button("Cancella tutti i salvataggi");
        deleteSavesButton.setOnAction(e -> {
            if (confirmDeleteSaves()) onDeleteSaves.run();
        });

        //torna indietro
        Button backButton = new Button("Indietro");
        backButton.setOnAction(e -> onBack.run());

        for (Button button : List.of(deleteSavesButton, backButton)) {
            button.setMaxWidth(Double.MAX_VALUE);
            button.setStyle("-fx-font-size: 16px; -fx-padding: 10 20;");
        }
        //il bottone distruttivo in rosso
        deleteSavesButton.setStyle(deleteSavesButton.getStyle()
                + "-fx-background-color: #a33; -fx-text-fill: white;");

        //messaggio di esito, vuoto all'inizio
        settingsMessage = new Label();
        settingsMessage.setWrapText(true);

        //riquadro centrale
        VBox panel = new VBox(25, title, difficultySection, deleteSavesButton, backButton, settingsMessage);
        panel.setAlignment(Pos.CENTER);
        panel.setPadding(new Insets(30));
        panel.setMaxSize(340, Region.USE_PREF_SIZE);
        panel.setStyle("-fx-background-color: #3a3a35; -fx-background-radius: 15;");

        this.setStyle("-fx-background-color: #2d2d29");
        this.getChildren().add(panel);
    }

    //il controller la chiama per mostrare la difficoltà salvata
    public void showDifficulty(Difficulty difficulty) {
        difficultyBox.setValue(difficulty);
    }

    public void showMessage(String message, boolean success) {
        settingsMessage.setTextFill(success ? Color.LIGHTGREEN : Color.SALMON);
        settingsMessage.setText(message);
    }

    //finestra di conferma: true solo se l'utente preme OK
    private boolean confirmDeleteSaves() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conferma");
        alert.setHeaderText("Cancellare tutti i salvataggi?");
        alert.setContentText("L'operazione non può essere annullata.");
        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }
}
