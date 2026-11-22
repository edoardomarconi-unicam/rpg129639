package it.unicam.rpg.model;

import it.unicam.rpg.view.Screen;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ViewNavigator {
    private Scene scene;
    private Parent previousRoot;

    public  ViewNavigator(Scene scene) {
        this.scene = scene;
    }

    public void NavigateTo(Screen<?> screen) {
        previousRoot = scene.getRoot();
        scene.setRoot(screen.createScreen(this));
    }

    public void goBack() {
        if(previousRoot != null){
            Parent current = scene.getRoot();
            scene.setRoot(previousRoot);
            previousRoot = current;
        };

    }
}
