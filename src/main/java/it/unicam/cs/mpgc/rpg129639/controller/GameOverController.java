package it.unicam.cs.mpgc.rpg129639.controller;

import it.unicam.cs.mpgc.rpg129639.view.ViewNavigator;
import it.unicam.cs.mpgc.rpg129639.view.gameOver.GameOverScene;
import it.unicam.cs.mpgc.rpg129639.view.mainMenu.MainMenuScreen;

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
