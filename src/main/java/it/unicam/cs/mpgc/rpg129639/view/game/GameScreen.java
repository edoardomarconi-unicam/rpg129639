package it.unicam.cs.mpgc.rpg129639.view.game;

import it.unicam.cs.mpgc.rpg129639.controller.GameController;
import it.unicam.cs.mpgc.rpg129639.model.Game;
import it.unicam.cs.mpgc.rpg129639.view.ViewNavigator;
import it.unicam.cs.mpgc.rpg129639.view.Screen;

public class GameScreen extends Screen<GameScene> {
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
