package it.unicam.rpg.model;

import it.unicam.rpg.view.Screen;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ViewNavigator {
    private Scene scene;

    public  ViewNavigator(Scene scene) {
        this.scene = scene;
    }

    public void NavigateTo(Screen<?> screen) {
        Parent view = screen.createScreen(this);
        scene.setRoot(view);
    }
}
