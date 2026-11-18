package it.unicam.rpg.controller;

import it.unicam.rpg.model.Game;
import it.unicam.rpg.model.data.GameSaverReader;
import it.unicam.rpg.model.players.User;
import it.unicam.rpg.view.GameScene;
import it.unicam.rpg.view.MainMenuScene;
import it.unicam.rpg.view.PlayerDataInputScene;
import javafx.scene.Scene;

public class MenuController {
    private GameSaverReader gameSaverReader;
    private Scene scene;
    private MainMenuScene mainMenuScene;

    public MenuController(Scene scene, MainMenuScene mainMenuScene){
        this.scene = scene;
        this.mainMenuScene = mainMenuScene;

        mainMenuScene.setOnContinueGame(() -> {
            Game game = gameSaverReader.loadSavedGame();
            GameScene gameScene = new GameScene(game.getUser(), game.getNpcs().getFirst());
            GameController gameController = new GameController(gameScene, game, scene);
            scene.setRoot(gameScene);
        });

        mainMenuScene.setOnNewGame(() ->  {
            PlayerDataInputScene playerDataInputScene = new PlayerDataInputScene();
            new PlayerDataInputController(scene, playerDataInputScene);
            scene.setRoot(playerDataInputScene);
        });
    }
}
