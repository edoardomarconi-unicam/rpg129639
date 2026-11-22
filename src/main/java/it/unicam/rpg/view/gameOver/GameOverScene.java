package it.unicam.rpg.view.gameOver;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class GameOverScene extends StackPane{
    Label gameOverReason;
    Button goToMainMenuButton = new Button("Menù principale");
    Runnable goToMainMenu = () -> {};

    public GameOverScene(String reason) {
        gameOverReason = new Label(reason);
        setLayout();

        goToMainMenuButton.setOnAction(event -> goToMainMenu.run());
    }

    private void setLayout(){
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(30);
        gameOverReason.setWrapText(true);
        gameOverReason.setTextFill(Color.WHITE);
        root.getChildren().add(gameOverReason);
        HBox buttons = new HBox(
                 goToMainMenuButton
        );
        buttons.setAlignment(Pos.CENTER);
        root.getChildren().add(buttons);
        this.getChildren().add(root);
        this.setStyle("-fx-background-color: #2d2d29");
        this.setAlignment(Pos.CENTER);
    }

    public void setGoToMainMenu(Runnable goToMainMenu){this.goToMainMenu = goToMainMenu;}
}
