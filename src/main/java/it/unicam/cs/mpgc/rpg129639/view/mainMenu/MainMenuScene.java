package it.unicam.cs.mpgc.rpg129639.view.mainMenu;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import java.util.List;

public class MainMenuScene extends StackPane{
    private Runnable onContinueGame = () -> {};
    private Runnable onNewGame = () -> {};
    private Runnable onSettings = () -> {};

    public void setOnContinueGame(Runnable onContinueGame) { this.onContinueGame = onContinueGame; }
    public void setOnNewGame(Runnable onNewGame) { this.onNewGame = onNewGame; }
    public void setOnSettings(Runnable onSettings) { this.onSettings = onSettings; }

    public MainMenuScene(){
        setMainMenuLayout();
    }

    private void setMainMenuLayout(){
        //titolo del gioco
        Label title = new Label("La strada non è casa");
        title.setTextFill(Color.WHITE);
        title.setWrapText(true);
        title.setTextAlignment(TextAlignment.CENTER);
        //la dimensione del titolo segue la larghezza della finestra
        title.styleProperty().bind(Bindings.concat(
                "-fx-font-weight: bold; -fx-font-size: ", this.widthProperty().divide(14), "px;"));

        //bottoni delle opzioni
        Button continueGameButton = new Button("Continua partita");
        continueGameButton.setOnAction(e -> onContinueGame.run());

        Button newGameButton = new Button("Nuova partita");
        newGameButton.setOnAction(e -> onNewGame.run());

        Button settingsButton = new Button("Impostazioni");
        settingsButton.setOnAction(e -> onSettings.run());

        VBox options = new VBox(15, continueGameButton, newGameButton, settingsButton);
        options.setAlignment(Pos.CENTER);
        options.setMaxWidth(250);
        //tutti i bottoni larghi quanto la VBox, quindi della stessa larghezza
        for (Button button : List.of(continueGameButton, newGameButton, settingsButton)) {
            button.setMaxWidth(Double.MAX_VALUE);
            button.setStyle("-fx-font-size: 16px; -fx-padding: 10 20;");
        }

        //titolo + opzioni
        VBox root = new VBox(60, title, options);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(40));

        this.getChildren().add(root);
        this.setStyle("-fx-background-color: #2d2d29");
        this.setAlignment(Pos.CENTER);
    }
}
