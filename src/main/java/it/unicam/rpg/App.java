package it.unicam.rpg;

import it.unicam.rpg.controller.GameController;
import it.unicam.rpg.model.Game;
import it.unicam.rpg.model.players.User;
import it.unicam.rpg.view.GameScene;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import it.unicam.rpg.view.*;

public class App extends Application {
    Game game;
    User user;
    //TODO sistemare la logica di init gioco con schermata iniziale e selzione partite
    @Override
    public void init(){
        user = new User("Edoardo", "player");
        game = new Game(user);
    }

    @Override
    public void start(Stage stage) {
        Label l = new Label("Insieme per i bambini");
        GameScene gameView = new GameScene(user, game.getNpcs().getFirst());
        Scene gameScene = new Scene(gameView, 800, 600);

        GameController controller = new GameController(gameView, game, gameScene);

        stage.setScene(gameScene);
        stage.setMinWidth(800);
        stage.setMinHeight(600);
        stage.show();
    }

    @Override
    public void stop(){
        System.out.println("Application stopped");
        System.exit(0);
    }

    public static void main(String[] args) {
        launch();
    }
}
