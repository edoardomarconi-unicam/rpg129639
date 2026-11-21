package it.unicam.rpg.controller;

import it.unicam.rpg.model.Game;
import it.unicam.rpg.model.ViewNavigator;
import it.unicam.rpg.model.data.GameSaverReader;
import it.unicam.rpg.view.GameScene;
import it.unicam.rpg.view.MainMenuScreen;
import it.unicam.rpg.view.PauseMenuView;

public class PauseMenuController {
    private PauseMenuView pauseMenuView;
    private ViewNavigator viewNavigator;

    public PauseMenuController(PauseMenuView pauseMenuView, ViewNavigator viewNavigator, Game game){
        this.pauseMenuView = pauseMenuView;
        this.viewNavigator = viewNavigator;
        menuButtonActions(game);
    }

    public void menuButtonActions(Game game){
        pauseMenuView.setOnMainMenu(() -> {
            new GameSaverReader(game).saveGame();
            viewNavigator.NavigateTo(new MainMenuScreen());
        });

        pauseMenuView.setOnSaveGame(() -> {
            if(new GameSaverReader(game).saveGame())
                System.out.println("Game saved successfully!");
            else
                System.out.println("Save failed!");
        });
    }
}
