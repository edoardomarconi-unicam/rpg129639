package it.unicam.rpg.controller;

import it.unicam.rpg.model.Game;
import it.unicam.rpg.persistence.GameContextSave;
import it.unicam.rpg.persistence.GameContextSaveTranslator;
import it.unicam.rpg.view.ViewNavigator;
import it.unicam.rpg.persistence.GameSaverReader;
import it.unicam.rpg.view.game.GameScreen;
import it.unicam.rpg.view.mainMenu.MainMenuScene;
import it.unicam.rpg.view.playerDataInput.PlayerDataInputScreen;
import it.unicam.rpg.view.settings.SettingsScreen;

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
