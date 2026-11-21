package it.unicam.rpg.controller;

import it.unicam.rpg.model.Game;
import it.unicam.rpg.model.ViewNavigator;
import it.unicam.rpg.view.*;
import javafx.scene.Scene;

//TODO sistemare navigazioni
public class PlayerDataInputController {
    private PlayerDataInputScene playerDataInputScene;
    private ViewNavigator viewNavigator;

    public PlayerDataInputController(PlayerDataInputScene playerDataInputScene, ViewNavigator viewNavigator) {
        this.playerDataInputScene = playerDataInputScene;
        this.viewNavigator = viewNavigator;

        playerDataInputScene.setOnBack(() ->{
            viewNavigator.NavigateTo(new MainMenuScreen());
        });

        playerDataInputScene.setOnStartGame((String playerName) -> {
            viewNavigator.NavigateTo(
                    new GameScreen(
                            new Game(playerName)
                    )
            );
        });
    }
}
