package it.unicam.rpg.view;

import it.unicam.rpg.model.GameObserver;
import it.unicam.rpg.model.players.Npc;
import it.unicam.rpg.model.players.User;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;

public class GameScene extends BorderPane implements GameObserver {
    private final double HORIZONTAL_SPACING = 30;
    User user;
    Npc npcs;
    private Label speakerName;
    private Label speakerRole;

    public GameScene(User user, Npc npc) {
        this.user = user;
        this.npcs = npc;

        setTopBar(user);
        setCenter(npc);

        String npcName = npc.getName();
        String npcRole = npc.getRole();
        setBottom(npcName, npcRole);

    }

    //metodo di supporto per creare PrograssBar dei parametri
    private VBox creaIndicatore(String nome, double valore) {
        ProgressBar bar = new ProgressBar(valore / 100); //ProgressBar considera valori tra 0.0 e 1.0
        bar.setMaxWidth(Double.MAX_VALUE);              // la barra riempie la VBox
        VBox box = new VBox(5, new Label(nome), bar);
        box.setAlignment(Pos.CENTER);
        HBox.setHgrow(box, Priority.ALWAYS);            // la VBox si divide lo spazio dell'HBox
        return box;
    }

    public void setTopBar(User user){
        double verticalSpacing = 5;

        HBox topBar = new HBox(
                HORIZONTAL_SPACING,
                creaIndicatore("Salute", user.getHealth()),
                creaIndicatore("Istruzione", user.getEducation()),
                creaIndicatore("Paura", user.getFear()),
                creaIndicatore("Legame con la strada", user.getBrotherhood())
        );

        topBar.setAlignment(Pos.CENTER);
        topBar.setPadding(new Insets(HORIZONTAL_SPACING));
        this.setTop(topBar);
    }

    public void setCenter(Npc npc){

        //StackPane for card+label
        StackPane cardLabel = new StackPane();
        cardLabel.setAlignment(Pos.CENTER);

        Rectangle card = new Rectangle();
        card.heightProperty().bind(this.heightProperty().multiply(0.55));
        card.widthProperty().bind(Bindings.min(
                card.heightProperty().multiply(0.75),   // mantiene le proporzioni 3:4
                this.widthProperty().multiply(0.8)));  // ma non esce dai bordi
        card.setFill(Color.FLORALWHITE);
        card.setArcWidth(20);
        card.setArcHeight(20);

        String questLabel = npc.getQuest();
        Label cardText = new Label(questLabel);
        cardText.setWrapText(true);// va a capo invece di uscire dalla carta
        cardText.setTextAlignment(TextAlignment.CENTER);
        StackPane.setAlignment(cardText, Pos.CENTER);
        cardText.maxWidthProperty().bind(card.widthProperty().subtract(40));
        cardLabel.getChildren().addAll(card, cardText);

        //card + label + buttons VBox
        VBox cardLabelButtons = new VBox();
        cardLabelButtons.setAlignment(Pos.CENTER);
        cardLabelButtons.setSpacing(20);
        VBox.setVgrow(cardLabel, Priority.ALWAYS);

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

        speakerName = new Label(npcName);
        speakerName.setStyle("-fx-font-weight: bold;");
        speakerName.setWrapText(true);
        speakerName.setTextAlignment(TextAlignment.CENTER);

        speakerRole = new Label(role);
        speakerRole.setStyle("-fx-font-size: 0.85em;");
        speakerRole.setWrapText(true);
        speakerRole.setTextAlignment(TextAlignment.CENTER);

        VBox speaker = new VBox(2, speakerName, speakerRole);
        speaker.setAlignment(Pos.CENTER);
        speaker.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(speaker, Priority.ALWAYS);

        HBox bottom = new HBox(speaker);
        bottom.setAlignment(Pos.CENTER);
        bottom.setPadding(new Insets(padding));

        this.setBottom(bottom);
    }

    public void parameterChanged(User user) {

    }

    public void loadedNewCard(Npc npc) {}

    public void gameOver(String reason){}



}
