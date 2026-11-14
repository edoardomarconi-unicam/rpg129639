package it.unicam.rpg;

import it.unicam.rpg.view.GameScene;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import it.unicam.rpg.view.*;

public class App extends Application {
    public void start(Stage stage) {
        Label l = new Label("Insieme per i bambini");
        Scene scene = new Scene(new StackPane(l), 800, 600); //allineamento al centro di default
        Scene game = new Scene(new GameScene(), 800, 600);
        stage.setScene(game);
        stage.show();
    }

    public void stop(){
        System.out.println("Application stopped");
        System.exit(0);
    }

    public static void main(String[] args) {
        launch();
    }
}
