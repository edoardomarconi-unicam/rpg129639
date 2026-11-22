package it.unicam.rpg.view.game;

import it.unicam.rpg.model.Game;
import it.unicam.rpg.model.GameObserver;
import it.unicam.rpg.model.card.ParameterType;
import it.unicam.rpg.model.players.Npc;
import it.unicam.rpg.model.players.User;
import it.unicam.rpg.view.pauseMenu.PauseMenuView;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;

import java.util.EnumMap;
import java.util.Map;
public class GameScene extends StackPane implements GameObserver {
    private final double HORIZONTAL_SPACING = 30;
    User user;
    Npc npcs;
    BorderPane root = new BorderPane();
    PauseMenuView pauseMenuView;
    HBox topBar;
    Map<ParameterType, ProgressBar> progressBars = new EnumMap<ParameterType, ProgressBar>(ParameterType.class);
    Rectangle card;
    String questLabel;
    String npcLeftAnswer;
    String npcRightAnswer;
    private Label speakerName;
    private Label speakerRole;
    //creo delle azioni runnable, alle quali poi game assegnerà del codice
    private Runnable onLeftClick = () -> {};
    private Runnable onRightClick = () -> {};
    private Runnable onSaveGame = () -> {};
    private Runnable onSettings = () -> {};
    private Runnable onMainMenu = () -> {};
    private Label pauseMessage;

    public void setOnSaveGame(Runnable onSaveGame) { this.onSaveGame = onSaveGame; }
    public void setOnSettings(Runnable onSettings) { this.onSettings = onSettings; }
    public void setOnMainMenu(Runnable onMainMenu) { this.onMainMenu = onMainMenu; }


    public GameScene(User user, Npc npc, Game game) {
        this.user = user;
        this.npcs = npc;
        String npcName = npc.getName();
        String npcRole = npc.getRole();

        setTopBar(user);
        setCenter(npc);
        setBottom(npcName, npcRole);

        this.getChildren().add(root);

        //tasto esc apre e chiude il menu
        this.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                if (pauseMenuView.isVisible()) pauseMenuView.closePauseMenu();
                else pauseMenuView.openPauseMenu();
                e.consume();
            }
        });
    }

    //metodo di supporto per creare ProgressBar dei parametri
    private VBox creaIndicatore(ParameterType type, String nome, double valore) {
        //ProgressBar considera valori tra 0.0 e 1.0
        ProgressBar bar = new ProgressBar(valore / 100);
        bar.setMaxWidth(Double.MAX_VALUE);
        progressBars.put(type, bar);

        VBox box = new VBox(5, new Label(nome), bar);
        box.setAlignment(Pos.CENTER);
        HBox.setHgrow(box, Priority.ALWAYS);
        return box;
    }

    public void setTopBar(User user){
        double verticalSpacing = 5;
        Button pauseButton = new Button("☰");
        pauseButton.setStyle("-fx-font-size: 18px;");
        pauseButton.setOnAction(e -> pauseMenuView.openPauseMenu());
        topBar = new HBox(
                HORIZONTAL_SPACING,
                creaIndicatore(ParameterType.HEALTH,"Salute", user.getHealth()),
                creaIndicatore(ParameterType.EDUCATION, "Istruzione", user.getEducation()),
                creaIndicatore(ParameterType.FEAR, "Paura", user.getFear()),
                creaIndicatore(ParameterType.BROTHERHOOD, "Legame con la strada", user.getBrotherhood())
        );

        topBar.setAlignment(Pos.CENTER);
        topBar.setPadding(new Insets(HORIZONTAL_SPACING));
        topBar.getChildren().add(pauseButton);
        root.setTop(topBar);
    }

    public void setCenter(Npc npc){

        //StackPane per card+label
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

        //buttons di scelta
        npcLeftAnswer = npc.getLeft().getLabel();
        npcRightAnswer = npc.getRight().getLabel();
        Button leftButton =  new Button(npcLeftAnswer);
        leftButton.setOnAction(e -> {onLeftClick.run();});
        Button rightButton =   new Button(npcRightAnswer);
        rightButton.setOnAction(e -> {onRightClick.run();});
        HBox buttons = new HBox(leftButton, rightButton);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(HORIZONTAL_SPACING);

        cardLabelButtons.getChildren().addAll(cardLabel,  buttons);

        root.setCenter(cardLabelButtons);
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

        root.setBottom(bottom);
    }

    public void setOnLeftChoice(Runnable onLeftClick){
        this.onLeftClick = onLeftClick;
    }
    public void setOnRightChoice(Runnable onRightClick){
        this.onRightClick = onRightClick;
    }

    //metodo di appoggio per aggiornare progressBars
    public void progressBarsUpdate(User user){
        progressBars.get(ParameterType.HEALTH).setProgress(user.getHealth()/100);
        progressBars.get(ParameterType.EDUCATION).setProgress(user.getEducation()/100);
        progressBars.get(ParameterType.FEAR).setProgress(user.getFear()/100);
        progressBars.get(ParameterType.BROTHERHOOD).setProgress(user.getBrotherhood()/100);
    }

    //metodo di appoggio per cambiare la carta.
    public void loadNewCard(Npc npc){
        setCenter(npc);
        speakerName.setText(npc.getName());
        speakerRole.setText(npc.getRole());
    }

    //metodo per creare il pannello del pause menu
    public void setPauseMenuView(PauseMenuView pauseMenuView){
        this.pauseMenuView = pauseMenuView;
        this.getChildren().add(pauseMenuView);
    }


    @Override
    public void parameterChanged(User user) {
        progressBarsUpdate(user);
    }

    public void loadedNewCard(Npc npc) {
        loadNewCard(npc);
    }

}
