package it.unicam.rpg.controller;

import it.unicam.rpg.model.Direction;
import it.unicam.rpg.model.Game;
import it.unicam.rpg.model.GameObserver;
import it.unicam.rpg.view.GameOverScene;
import it.unicam.rpg.view.GameScene;
import it.unicam.rpg.view.MainMenuScene;
import javafx.scene.Scene;

public class GameController implements GameObserver {
    private GameScene gameScene;
    private Game game;
    private Scene scene;

    public GameController (GameScene gameScene,  Game game, Scene scene) {
        this.gameScene = gameScene;
        this.game = game;
        this.scene = scene;

        game.addObserver(gameScene);
        game.addObserver(this);

        gameScene.setOnRightChoice(() -> {game.choose(Direction.RIGHT, game.getUser());});
        gameScene.setOnLeftChoice(() -> {game.choose(Direction.LEFT, game.getUser());});
    }

    public void gameOver(String reason){
        GameOverScene gameOverScene = new GameOverScene(reason);
        GameOverController gameOverController = new GameOverController(scene,gameOverScene);
        scene.setRoot(gameOverScene);
    }

}
