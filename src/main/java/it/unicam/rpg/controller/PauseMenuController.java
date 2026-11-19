package it.unicam.rpg.controller;

import it.unicam.rpg.view.GameScene;

public class PauseMenuController {
    private GameScene gameScene;

    public PauseMenuController(GameScene gameScene){
        this.gameScene = gameScene;
    }

    public void menuButtonActions(){
        gameScene.setOnMainMenu(() -> {

        });
    }
}
