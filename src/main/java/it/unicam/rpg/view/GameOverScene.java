package it.unicam.rpg.view;

import it.unicam.rpg.model.GameObserver;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

//TODO sistemare responsiveness del pannello
public class GameOverScene extends StackPane implements GameObserver {
    Label gameOverReason;

    public GameOverScene(String reason) {
        gameOverReason = new Label(reason);
        setLayout();
    }

    private void setLayout(){
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        gameOverReason.setWrapText(true);
        gameOverReason.setTextFill(Color.WHITE);
        root.getChildren().add(gameOverReason);
        HBox buttons = new HBox(
                 new Button("Menù principale")
        );
        buttons.setAlignment(Pos.CENTER);
        root.getChildren().add(buttons);
        this.getChildren().add(root);
        this.setStyle("-fx-background-color: #2d2d29");
        this.setAlignment(Pos.CENTER);
    }
}
