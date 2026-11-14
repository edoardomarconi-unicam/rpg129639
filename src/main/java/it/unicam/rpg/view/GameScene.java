package it.unicam.rpg.view;

import it.unicam.rpg.model.GameObserver;
import it.unicam.rpg.model.players.Npc;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameScene extends BorderPane {
    private final double HORIZONTAL_SPACING = 30;

    public GameScene() {
        setTopBar();
        setCenter();
        setBottom();
    }

    public void loadedNewCard(Npc npc) {}

    public void setTopBar(){
        double verticalSpacing = 5;

        HBox topBar = new HBox(
                HORIZONTAL_SPACING,
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
        double verticalSpacing = 30;


        VBox center = new VBox();
        center.setSpacing(verticalSpacing);
        center.setAlignment(Pos.CENTER);

        //cardPanel + variable text on card
        StackPane cardPanel = new StackPane();

        Rectangle card = new Rectangle(300, 400);
        card.setFill(Color.FLORALWHITE);
        card.setArcWidth(20);
        card.setArcHeight(20);

        Label cardText = new Label("Nome e ruolo");
        cardText.setTranslateY(card.getY() + 150);

        cardPanel.getChildren().addAll(card, cardText);

        //choose buttons
        HBox buttons = new HBox(new Button("No"), new Button("Si"));
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(HORIZONTAL_SPACING);

        //loads the stackPan inside the VBox in the center
        center.getChildren().addAll(cardPanel,  buttons);

        this.setCenter(center);
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
