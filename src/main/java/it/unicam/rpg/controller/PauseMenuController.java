package it.unicam.rpg.controller;

import it.unicam.rpg.model.Game;
import it.unicam.rpg.model.GameContextSave;
import it.unicam.rpg.model.GameContextSaveTranslator;
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
            GameContextSave saving = GameContextSaveTranslator.translateFromGame(game);
            new GameSaverReader(saving).saveGame();
            viewNavigator.NavigateTo(new MainMenuScreen());
        });

        pauseMenuView.setOnSaveGame(() -> {
            GameContextSave saving = GameContextSaveTranslator.translateFromGame(game);
            if(new GameSaverReader(saving).saveGame()){
                System.out.println("Game saved successfully!");
            } else
                System.out.println("Save failed!");
        });
    }
}
