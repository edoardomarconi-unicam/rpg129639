package it.unicam.rpg.controller;

import it.unicam.rpg.model.Direction;
import it.unicam.rpg.model.Game;
import it.unicam.rpg.model.GameObserver;
import it.unicam.rpg.model.ViewNavigator;
import it.unicam.rpg.data.SettingsLoaderSaver;
import it.unicam.rpg.view.*;
import it.unicam.rpg.view.gameOver.GameOverScreen;

public class GameController implements GameObserver {
    private GameScene gameScene;
    private Game game;
    private ViewNavigator viewNavigator;

    public GameController (GameScene gameScene,  Game game, ViewNavigator viewNavigator) {
        this.gameScene = gameScene;
        this.game = game;
        this.viewNavigator = viewNavigator;

        this.gameScene.setPauseMenuView(new PauseMenuScreen(game).createScreen(viewNavigator));
        game.setDifficulty(new SettingsLoaderSaver().load().getDifficulty());

        game.addObserver(gameScene);
        game.addObserver(this);

        this.gameScene.setOnRightChoice(() -> {game.choose(Direction.RIGHT, game.getUser());});
        this.gameScene.setOnLeftChoice(() -> {game.choose(Direction.LEFT, game.getUser());});
    }

    public void gameOver(String reason){
        viewNavigator.NavigateTo(new GameOverScreen(reason));
    }


}
