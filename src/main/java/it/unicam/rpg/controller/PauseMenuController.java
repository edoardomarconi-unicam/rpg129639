package it.unicam.rpg.controller;

import it.unicam.rpg.model.ViewNavigator;
import it.unicam.rpg.view.GameScene;
import it.unicam.rpg.view.PauseMenuView;

public class PauseMenuController {
    private PauseMenuView pauseMenuView;
    private ViewNavigator viewNavigator;

    public PauseMenuController(PauseMenuView pauseMenuView, ViewNavigator viewNavigator){
        this.pauseMenuView = pauseMenuView;
    }

    public void menuButtonActions(){
        pauseMenuView.setOnMainMenu(() -> {

        });
    }
}
