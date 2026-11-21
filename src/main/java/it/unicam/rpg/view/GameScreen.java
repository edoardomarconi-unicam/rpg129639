package it.unicam.rpg.view;

import it.unicam.rpg.controller.GameController;
import it.unicam.rpg.model.Game;
import it.unicam.rpg.model.ViewNavigator;

public class GameScreen extends Screen <GameScene>{
    private Game game;

    public GameScreen(Game game) {
        this.game = game;
    }

    @Override
    protected GameScene createView() {
        return new GameScene(game.getUser(), game.getCurrentNpc(), game);
    }

    @Override
    protected void createController(GameScene view, ViewNavigator viewNavigator) {
        new GameController(view, game, viewNavigator );
    }
}
