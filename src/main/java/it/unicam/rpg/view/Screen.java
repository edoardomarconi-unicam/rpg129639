package it.unicam.rpg.view;

import it.unicam.rpg.model.ViewNavigator;
import javafx.scene.Parent;

public abstract class Screen <K extends Parent>{
    public K createScreen(ViewNavigator viewNavigator) {
        K view = this.createView();
        createController(view, viewNavigator);
        return view;
    }

    public abstract K createView();
    public abstract void createController(K view, ViewNavigator viewNavigator);
}
