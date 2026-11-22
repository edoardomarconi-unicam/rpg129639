package it.unicam.cs.mpgc.rpg129639.controller;

import it.unicam.cs.mpgc.rpg129639.model.Game;
import it.unicam.cs.mpgc.rpg129639.view.ViewNavigator;
import it.unicam.cs.mpgc.rpg129639.view.game.GameScreen;
import it.unicam.cs.mpgc.rpg129639.view.mainMenu.MainMenuScreen;
import it.unicam.cs.mpgc.rpg129639.view.playerDataInput.PlayerDataInputScene;

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
