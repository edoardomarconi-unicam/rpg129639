package it.unicam.cs.mpgc.rpg129639.view;

import javafx.scene.Parent;

public abstract class Screen <K extends Parent>{
    public K createScreen(ViewNavigator viewNavigator) {
        K view = this.createView();
        createController(view, viewNavigator);
        return view;
    }

    protected abstract K createView();
    protected abstract void createController(K view, ViewNavigator viewNavigator);
}
