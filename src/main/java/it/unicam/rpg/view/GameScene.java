package it.unicam.rpg.view;

import it.unicam.rpg.model.GameObserver;
import it.unicam.rpg.model.players.Npc;
import it.unicam.rpg.model.players.User;
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

public class GameScene extends BorderPane implements GameObserver {
    private final double HORIZONTAL_SPACING = 30;
    User user;
    Npc npcs;

    public GameScene(User user, Npc npc) {
        this.user = user;
        this.npcs = npc;

        setTopBar(user);
        setCenter(npc);

        String npcName = npc.getName();
        String npcRole = npc.getRole();
        setBottom(npcName, npcRole);
    }

    public void setTopBar(User user){
        double verticalSpacing = 5;

        HBox topBar = new HBox(
                HORIZONTAL_SPACING,
                new VBox(
                        verticalSpacing,
                        new Label("Salute"),
                        new ProgressBar(user.getHealth())
                ),
                new VBox(
                        verticalSpacing,
                        new Label("Istruzione"),
                        new ProgressBar(user.getEducation())
                ),
                new VBox(
                        verticalSpacing,
                        new Label("Paura"),
                        new ProgressBar(user.getFear())
                ),
                new VBox(
                        verticalSpacing,
                        new Label("Fratellanza"),
                        new ProgressBar(user.getBrotherhood())
                ));
        topBar.setAlignment(Pos.CENTER);
        this.setTop(topBar);
    }

    public void setCenter(Npc npc){
        double verticalSpacing = 30;

        //StackPane for card+label
        StackPane cardLabel = new StackPane();
        cardLabel.setAlignment(Pos.CENTER);

        Rectangle card = new Rectangle(300, 400);
        card.setFill(Color.FLORALWHITE);
        card.setArcWidth(20);
        card.setArcHeight(20);

        String questLabel = npc.getQuest();
        Label cardText = new Label(questLabel);
        cardText.setTranslateY(card.getY() + 150);

        cardLabel.getChildren().addAll(card, cardText);

        //card + label + buttons VBox
        VBox cardLabelButtons = new VBox();

        //choose buttons
        String npcLeftAnswer = npc.getLeft().getLabel();
        String npcRightAnswer = npc.getRight().getLabel();
        HBox buttons = new HBox(new Button(npcLeftAnswer), new Button(npcRightAnswer));
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(HORIZONTAL_SPACING);

        cardLabelButtons.getChildren().addAll(cardLabel,  buttons);

        this.setCenter(cardLabelButtons);
    }

    public void setBottom(String npcName, String role){
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

    public void parameterChanged(User user) {

    }

    public void loadedNewCard(Npc npc) {}

    public void gameOver(String reason){}



}
