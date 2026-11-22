package it.unicam.cs.mpgc.rpg129639.view.gameOver;

import it.unicam.cs.mpgc.rpg129639.controller.GameOverController;
import it.unicam.cs.mpgc.rpg129639.view.ViewNavigator;
import it.unicam.cs.mpgc.rpg129639.view.Screen;

public class GameOverScreen extends Screen<GameOverScene> {
    String gameOverMessage;

    public GameOverScreen(String gameOverMessage){
        this.gameOverMessage = gameOverMessage;
    }

    protected GameOverScene createView(){
        return new GameOverScene(gameOverMessage);
    }

    protected void createController(GameOverScene view, ViewNavigator viewNavigator){
        new GameOverController(view, viewNavigator);
    }
}
