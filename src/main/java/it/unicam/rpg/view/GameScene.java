package it.unicam.rpg.view;

import it.unicam.rpg.model.players.Parameters;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameScene extends BorderPane {

    public GameScene() {
        setTopBar();
        setCenter();
        setBottom();
    }

    public void setTopBar(){
        double horizontalSpacing = 30;
        double verticalSpacing = 5;

        HBox topBar = new HBox(
                horizontalSpacing,
                new VBox(
                        verticalSpacing,
                        new Label("Salute"),
                        new ProgressBar()
                ),
                new VBox(
                        verticalSpacing,
                        new Label("Istruzione"),
                        new ProgressBar()
                ),
                new VBox(
                        verticalSpacing,
                        new Label("Paura"),
                        new ProgressBar()
                ),
                new VBox(
                        verticalSpacing,
                        new Label("Fratellanza"),
                        new ProgressBar()
                ));
        topBar.setAlignment(Pos.CENTER);
        this.setTop(topBar);
    }

    public void setCenter(){
        StackPane centerCard = new StackPane();

        Rectangle card = new Rectangle(300, 400);
        card.setFill(Color.FLORALWHITE);
        card.setArcWidth(20);
        card.setArcHeight(20);

        Label cardText = new Label("Nome e ruolo");
        cardText.setTranslateY(card.getY() + 150);

        centerCard.getChildren().addAll(card, cardText);
        this.setCenter(centerCard);
    }

    public void setBottom(){
        double padding = 40;

        HBox bottom = new HBox();
        bottom.setAlignment(Pos.CENTER);
        bottom.setPadding(new Insets(0, padding, padding, padding));

        Label bottomText = new Label("Nome di chi parla");
        bottomText.setMaxHeight(50);
        bottomText.setMaxWidth(150);
        bottomText.setAlignment(Pos.CENTER);

        bottom.getChildren().addAll(bottomText);
        this.setBottom(bottom);
    }


}
