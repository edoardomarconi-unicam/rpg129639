package it.unicam.rpg.view;

import it.unicam.rpg.controller.GameController;
import it.unicam.rpg.model.Game;
import it.unicam.rpg.model.ViewNavigator;
import it.unicam.rpg.model.players.Npc;
import it.unicam.rpg.model.players.User;
import javafx.scene.Parent;

import static javafx.scene.input.KeyCode.K;

public class GameScreen extends Screen <GameScene>{
    private Game game;

    public GameScreen(Game game) {
        this.game = game;
    }

    @Override
    public GameScene createView() {
        return new GameScene(game.getUser(), game.getCurrentNpc());
    }

    @Override
    public void createController(GameScene view, ViewNavigator viewNavigator) {
        new GameController(view, game, viewNavigator );
    }
}
