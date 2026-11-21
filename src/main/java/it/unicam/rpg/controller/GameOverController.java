package it.unicam.rpg.controller;

import it.unicam.rpg.view.GameOverScene;
import it.unicam.rpg.view.MainMenuScene;
import javafx.scene.Scene;

public class GameOverController {
    private Scene scene;
    private GameOverScene gameOverScene;

    public GameOverController(Scene scene, GameOverScene gameOverScene){
        this.scene = scene;
        this.gameOverScene = gameOverScene;

        gameOverScene.setGoToMainMenu(() -> {
            MainMenuScene mainMenuScene = new MainMenuScene();
            MainMenuController mainMenuController = new MainMenuController(scene,mainMenuScene);
            scene.setRoot(mainMenuScene);
        });
    }
}
