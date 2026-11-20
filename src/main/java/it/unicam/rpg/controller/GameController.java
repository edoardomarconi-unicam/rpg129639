package it.unicam.rpg.controller;

import it.unicam.rpg.model.Direction;
import it.unicam.rpg.model.Game;
import it.unicam.rpg.model.GameObserver;
import it.unicam.rpg.model.ViewNavigator;
import it.unicam.rpg.view.GameOverScene;
import it.unicam.rpg.view.GameOverScreen;
import it.unicam.rpg.view.GameScene;
import it.unicam.rpg.view.MainMenuScene;
import javafx.scene.Scene;

//TODO vedere problemi legati a modifica
public class GameController implements GameObserver {
    private GameScene gameScene;
    private Game game;
    private ViewNavigator viewNavigator;

    public GameController (GameScene gameScene,  Game game, ViewNavigator viewNavigator) {
        this.gameScene = gameScene;
        this.game = game;
        this.viewNavigator = viewNavigator;

        game.addObserver(gameScene);
        game.addObserver(this);

        gameScene.setOnRightChoice(() -> {game.choose(Direction.RIGHT, game.getUser());});
        gameScene.setOnLeftChoice(() -> {game.choose(Direction.LEFT, game.getUser());});
    }

    public void gameOver(String reason){
        viewNavigator.NavigateTo(new GameOverScreen(reason));
    }


}
