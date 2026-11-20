package it.unicam.rpg.controller;

import it.unicam.rpg.model.Game;
import it.unicam.rpg.model.ViewNavigator;
import it.unicam.rpg.view.GameScene;
import it.unicam.rpg.view.MainMenuScene;
import it.unicam.rpg.view.PlayerDataInputScene;
import javafx.scene.Scene;

//TODO sistemare navigazioni
public class PlayerDataInputController {
    private PlayerDataInputScene playerDataInputScene;
    private ViewNavigator viewNavigator;

    public PlayerDataInputController(PlayerDataInputScene playerDataInputScene, ViewNavigator viewNavigator) {
        this.playerDataInputScene = playerDataInputScene;
        this.viewNavigator = viewNavigator;

        playerDataInputScene.setOnBack(() ->{
            viewNavigator.NavigateTo();
        });

        playerDataInputScene.setOnStartGame((String playerName) -> {
            Game game = new Game(playerName);
            GameScene gameScene = new GameScene(game.getUser(), game.getNpcs().getFirst());
            new GameController(gameScene, game, scene);
            scene.setRoot(gameScene);
        });
    }
}
