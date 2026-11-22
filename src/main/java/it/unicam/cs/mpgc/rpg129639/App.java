package it.unicam.cs.mpgc.rpg129639;

import it.unicam.cs.mpgc.rpg129639.view.ViewNavigator;
import it.unicam.cs.mpgc.rpg129639.view.mainMenu.MainMenuScreen;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void init(){
    }

    @Override
    public void start(Stage stage) {
        //creo una scena temporanea per poter inizializzare il ViewNavigator
        Scene scene = new Scene(new StackPane());

        //creo e vado al main menu
        ViewNavigator viewNavigator = new ViewNavigator(scene);
        viewNavigator.NavigateTo(new MainMenuScreen());

        stage.setScene(scene);
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
