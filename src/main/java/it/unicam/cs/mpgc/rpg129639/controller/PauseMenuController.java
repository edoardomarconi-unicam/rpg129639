package it.unicam.cs.mpgc.rpg129639.controller;

import it.unicam.cs.mpgc.rpg129639.model.Game;
import it.unicam.cs.mpgc.rpg129639.persistence.GameContextSave;
import it.unicam.cs.mpgc.rpg129639.persistence.GameContextSaveTranslator;
import it.unicam.cs.mpgc.rpg129639.view.ViewNavigator;
import it.unicam.cs.mpgc.rpg129639.persistence.GameSaverReader;
import it.unicam.cs.mpgc.rpg129639.view.mainMenu.MainMenuScreen;
import it.unicam.cs.mpgc.rpg129639.view.pauseMenu.PauseMenuView;
import it.unicam.cs.mpgc.rpg129639.view.settings.SettingsScreen;

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

        pauseMenuView.setOnSettings(() -> {
            viewNavigator.NavigateTo(new SettingsScreen());
        });
    }
}
