package it.unicam.rpg.view;

import it.unicam.rpg.controller.GameOverController;
import it.unicam.rpg.model.ViewNavigator;

public class GameOverScreen extends Screen<GameOverScene>{
    String gameOverMessage;

    public GameOverScreen(String gameOverMessage){
        this.gameOverMessage = gameOverMessage;
    }

    protected GameOverScene createView(){
        return new GameOverScene(gameOverMessage);
    }

    protected void createController(GameOverScene view, ViewNavigator viewNavigator){
        new GameOverController(view);
    }
}
