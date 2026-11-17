package it.unicam.rpg.view;

import it.unicam.rpg.model.GameObserver;
import it.unicam.rpg.model.ParameterType;
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

import java.util.EnumMap;
import java.util.Map;

public class GameScene extends BorderPane implements GameObserver {
    private final double HORIZONTAL_SPACING = 30;
    User user;
    Npc npcs;
    HBox topBar;
    Map<ParameterType, ProgressBar> progressBars = new EnumMap<ParameterType, ProgressBar>(ParameterType.class);
    Rectangle card;
    String questLabel;
    String npcLeftAnswer;
    String npcRightAnswer;
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
    private VBox creaIndicatore(ParameterType type, String nome, double valore) {
        ProgressBar bar = new ProgressBar(valore / 100); //ProgressBar considera valori tra 0.0 e 1.0
        bar.setMaxWidth(Double.MAX_VALUE);              // la barra riempie la VBox
        progressBars.put(type, bar);

        VBox box = new VBox(5, new Label(nome), bar); //inserisco l'oggetto bar perchè è lo stesso oggetto che ho
        box.setAlignment(Pos.CENTER);                           //collegato alla Map progressBar, quindi bar == progressBar.get(type)
        HBox.setHgrow(box, Priority.ALWAYS);            // la VBox si divide lo spazio dell'HBox
        return box;
    }

    public void setTopBar(User user){
        double verticalSpacing = 5;

        topBar = new HBox(
                HORIZONTAL_SPACING,
                creaIndicatore(ParameterType.HEALTH,"Salute", user.getHealth()),
                creaIndicatore(ParameterType.EDUCATION, "Istruzione", user.getEducation()),
                creaIndicatore(ParameterType.FEAR, "Paura", user.getFear()),
                creaIndicatore(ParameterType.BROTHERHOOD, "Legame con la strada", user.getBrotherhood())
        );

        topBar.setAlignment(Pos.CENTER);
        topBar.setPadding(new Insets(HORIZONTAL_SPACING));
        this.setTop(topBar);
    }

    public void setCenter(Npc npc){

        //StackPane for card+label
        StackPane cardLabel = new StackPane();
        cardLabel.setAlignment(Pos.CENTER);

        //carta
        card = new Rectangle();
        card.heightProperty().bind(this.heightProperty().multiply(0.55));
        card.widthProperty().bind(Bindings.min(
                card.heightProperty().multiply(0.75),   // mantiene le proporzioni 3:4
                this.widthProperty().multiply(0.8)));  // ma non esce dai bordi
        card.setFill(Color.FLORALWHITE);
        card.setArcWidth(20);
        card.setArcHeight(20);

        //domanda dell'NPC
        questLabel = npc.getQuest();
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
        npcLeftAnswer = npc.getLeft().getLabel();
        npcRightAnswer = npc.getRight().getLabel();
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

    //metodo di appoggio per aggiornare progressBars
    public void progressBarsUpdate(User user){
        progressBars.get(ParameterType.HEALTH).setProgress(user.getHealth());
        progressBars.get(ParameterType.EDUCATION).setProgress(user.getEducation());
        progressBars.get(ParameterType.FEAR).setProgress(user.getFear());
        progressBars.get(ParameterType.BROTHERHOOD).setProgress(user.getBrotherhood());
    }

    //metodo di appoggio per cambiare la carta.
    public void loadNewCard(Npc npc){
        questLabel = npc.getQuest();
        npcLeftAnswer = npc.getLeft().getLabel();
        npcRightAnswer = npc.getRight().getLabel();
    }

    @Override
    public void parameterChanged(User user) {
        progressBarsUpdate(user);
    }

    public void loadedNewCard(Npc npc) {
        loadNewCard(npc);
    }

    public void gameOver(String reason){}



}
