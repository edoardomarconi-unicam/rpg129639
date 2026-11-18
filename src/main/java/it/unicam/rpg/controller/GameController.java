package it.unicam.rpg.controller;

import it.unicam.rpg.model.Direction;
import it.unicam.rpg.model.Game;
import it.unicam.rpg.view.GameScene;

public class GameController {
    private GameScene gameScene;
    private Game game;
    public GameController(GameScene gameScene,  Game game) {
        this.gameScene = gameScene;
        this.game = game;

        game.addObserver(gameScene);

        gameScene.setOnRightChoice(() -> {game.choose(Direction.RIGHT, game.getUser());});
        gameScene.setOnLeftChoice(() -> {game.choose(Direction.LEFT, game.getUser());});
    }
}
