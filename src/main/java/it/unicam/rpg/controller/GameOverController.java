package it.unicam.rpg.controller;

import it.unicam.rpg.view.GameOverScene;
import it.unicam.rpg.view.MainMenuScene;
import javafx.scene.Scene;

//TODO sistemare la navigazione del pulsante per tornare al main menu
public class GameOverController {
    private GameOverScene gameOverScene;

    public GameOverController(GameOverScene gameOverScene){
        this.gameOverScene = gameOverScene;

        gameOverScene.setGoToMainMenu(() -> {
            MainMenuScene mainMenuScene = new MainMenuScene();
            MainMenuController mainMenuController = new MainMenuController(scene,mainMenuScene);
            scene.setRoot(mainMenuScene);
        });
    }
}
