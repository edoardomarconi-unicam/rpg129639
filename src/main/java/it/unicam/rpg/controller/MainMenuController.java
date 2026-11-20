package it.unicam.rpg.controller;

import it.unicam.rpg.model.Game;
import it.unicam.rpg.model.GameContextSave;
import it.unicam.rpg.model.GameContextSaveTranslator;
import it.unicam.rpg.model.ViewNavigator;
import it.unicam.rpg.model.data.GameSaverReader;
import it.unicam.rpg.view.*;
import javafx.scene.Scene;

public class MainMenuController {
    private GameSaverReader gameSaverReader;
    private MainMenuScene mainMenuScene;
    private ViewNavigator viewNavigator;

    public MainMenuController(MainMenuScene mainMenuScene, ViewNavigator viewNavigator){
        this.mainMenuScene = mainMenuScene;
        this.viewNavigator = viewNavigator;

        mainMenuScene.setOnContinueGame(() -> {
            GameContextSave saving = new GameContextSave();
            Game game = GameContextSaveTranslator.translateToGame(
                    new GameSaverReader(saving).loadSavedGame());
            viewNavigator.NavigateTo(new GameScreen(game));
        });

        mainMenuScene.setOnNewGame(() ->  {
            viewNavigator.NavigateTo(new PlayerDataInputScreen());
        });
    }
}
