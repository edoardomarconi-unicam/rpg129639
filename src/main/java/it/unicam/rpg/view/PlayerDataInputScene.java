package it.unicam.rpg.view;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import java.util.function.Consumer;

public class PlayerDataInputScene extends StackPane {
    private static final int MAX_NAME_LENGTH = 20;

    //il controller riceve il nome inserito
    private Consumer<String> onStartGame = name -> {};
    private Runnable onBack = () -> {};

    public void setOnStartGame(Consumer<String> onStartGame) { this.onStartGame = onStartGame; }
    public void setOnBack(Runnable onBack) { this.onBack = onBack; }

    public PlayerDataInputScene() {
        setPlayerDataInputLayout();
    }

    private void setPlayerDataInputLayout() {
        //titolo
        Label title = new Label("Come ti chiami?");
        title.setTextFill(Color.WHITE);
        title.setWrapText(true);
        title.setTextAlignment(TextAlignment.CENTER);
        title.styleProperty().bind(Bindings.concat(
                "-fx-font-weight: bold; -fx-font-size: ", this.widthProperty().divide(22), "px;"));

        //campo per il nome
        TextField nameField = new TextField();
        nameField.setPromptText("Inserisci il tuo nome");
        nameField.setMaxWidth(300);
        nameField.setStyle("-fx-font-size: 16px; -fx-padding: 10;");
        //blocca l'inserimento oltre MAX_NAME_LENGTH caratteri
        nameField.setTextFormatter(new TextFormatter<String>(change ->
                change.getControlNewText().length() <= MAX_NAME_LENGTH ? change : null));

        //bottoni
        Button startButton = new Button("Inizia partita");
        startButton.setOnAction(e -> onStartGame.accept(nameField.getText().trim()));
        //disattivato finché il nome è vuoto (o solo spazi)
        startButton.disableProperty().bind(Bindings.createBooleanBinding(
                () -> nameField.getText().trim().isEmpty(), nameField.textProperty()));

        Button backButton = new Button("Indietro");
        backButton.setOnAction(e -> onBack.run());

        for (Button button : new Button[]{backButton, startButton}) {
            button.setStyle("-fx-font-size: 16px; -fx-padding: 10 20;");
        }

        //premendo Invio nel campo si avvia la partita, se il nome è valido
        nameField.setOnAction(e -> {
            if (!startButton.isDisabled()) startButton.fire();
        });

        HBox buttons = new HBox(20, backButton, startButton);
        buttons.setAlignment(Pos.CENTER);

        //titolo + campo + bottoni
        VBox root = new VBox(30, title, nameField, buttons);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(40));

        this.getChildren().add(root);
        this.setStyle("-fx-background-color: #2d2d29");
        this.setAlignment(Pos.CENTER);
    }
}