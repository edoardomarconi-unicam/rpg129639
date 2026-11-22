package it.unicam.cs.mpgc.rpg129639.controller;

import it.unicam.cs.mpgc.rpg129639.model.Direction;
import it.unicam.cs.mpgc.rpg129639.model.Game;
import it.unicam.cs.mpgc.rpg129639.model.GameObserver;
import it.unicam.cs.mpgc.rpg129639.view.ViewNavigator;
import it.unicam.cs.mpgc.rpg129639.persistence.SettingsLoaderSaver;
import it.unicam.cs.mpgc.rpg129639.view.game.GameScene;
import it.unicam.cs.mpgc.rpg129639.view.gameOver.GameOverScreen;
import it.unicam.cs.mpgc.rpg129639.view.pauseMenu.PauseMenuScreen;

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
