package it.unicam.cs.mpgc.rpg129639.controller;

import it.unicam.cs.mpgc.rpg129639.model.Game;
import it.unicam.cs.mpgc.rpg129639.persistence.GameContextSave;
import it.unicam.cs.mpgc.rpg129639.persistence.GameContextSaveTranslator;
import it.unicam.cs.mpgc.rpg129639.view.ViewNavigator;
import it.unicam.cs.mpgc.rpg129639.persistence.GameSaverReader;
import it.unicam.cs.mpgc.rpg129639.view.game.GameScreen;
import it.unicam.cs.mpgc.rpg129639.view.mainMenu.MainMenuScene;
import it.unicam.cs.mpgc.rpg129639.view.playerDataInput.PlayerDataInputScreen;
import it.unicam.cs.mpgc.rpg129639.view.settings.SettingsScreen;

public class MainMenuController {
    private GameSaverReader gameSaverReader;
    private MainMenuScene mainMenuScene;
    private ViewNavigator viewNavigator;

    public MainMenuController(MainMenuScene mainMenuScene, ViewNavigator viewNavigator){
        this.mainMenuScene = mainMenuScene;
        this.viewNavigator = viewNavigator;

        mainMenuScene.setOnContinueGame(() -> {
            GameContextSave saving = new GameContextSave();

            if(new GameSaverReader(saving).loadSavedGame() == null){
                viewNavigator.NavigateTo(new PlayerDataInputScreen());
                System.out.println("no saves found");
            }else{
                Game game = GameContextSaveTranslator.translateToGame(
                        new GameSaverReader(saving).loadSavedGame());
                viewNavigator.NavigateTo(new GameScreen(game));
            }
        });

        mainMenuScene.setOnNewGame(() ->  {
            viewNavigator.NavigateTo(new PlayerDataInputScreen());
        });

        mainMenuScene.setOnSettings(() -> {
            viewNavigator.NavigateTo(new SettingsScreen());
        });
    }
}
