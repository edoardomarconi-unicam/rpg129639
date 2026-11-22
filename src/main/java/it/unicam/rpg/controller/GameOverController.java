package it.unicam.rpg.controller;

import it.unicam.rpg.view.ViewNavigator;
import it.unicam.rpg.view.gameOver.GameOverScene;
import it.unicam.rpg.view.mainMenu.MainMenuScreen;

//TODO sistemare la navigazione del pulsante per tornare al main menu
public class GameOverController {
    private GameOverScene gameOverScene;
    private ViewNavigator viewNavigator;

    public GameOverController(GameOverScene gameOverScene, ViewNavigator viewNavigator) {
        this.gameOverScene = gameOverScene;
        this.viewNavigator = viewNavigator;

        gameOverScene.setGoToMainMenu(() -> {
            viewNavigator.NavigateTo(new MainMenuScreen());
        });
    }
}
