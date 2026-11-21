package it.unicam.rpg.controller;

import it.unicam.rpg.model.Game;
import it.unicam.rpg.view.GameScene;
import it.unicam.rpg.view.MainMenuScene;
import it.unicam.rpg.view.PlayerDataInputScene;
import javafx.scene.Scene;

public class PlayerDataInputController {
    private Scene scene;
    private PlayerDataInputScene playerDataInputScene;

    public PlayerDataInputController(Scene scene, PlayerDataInputScene playerDataInputScene) {
        this.scene = scene;
        this.playerDataInputScene = playerDataInputScene;

        playerDataInputScene.setOnBack(() ->{
            scene.setRoot(new MainMenuScene());
        });

        playerDataInputScene.setOnStartGame((String playerName) -> {
            Game game = new Game(playerName);
            GameScene gameScene = new GameScene(game.getUser(), game.getNpcs().getFirst());
            new GameController(gameScene, game, scene);
            scene.setRoot(gameScene);
        });
    }
}
