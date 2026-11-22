package it.unicam.rpg.view.pauseMenu;

import it.unicam.rpg.controller.PauseMenuController;
import it.unicam.rpg.model.Game;
import it.unicam.rpg.view.ViewNavigator;
import it.unicam.rpg.view.Screen;

public class PauseMenuScreen extends Screen<PauseMenuView> {
    Game game;
    public PauseMenuScreen(Game game) {
        this.game = game;
    }
    protected PauseMenuView createView(){
        return new PauseMenuView();
    }
    protected void createController(PauseMenuView view, ViewNavigator viewNavigator){
        new PauseMenuController(view, viewNavigator, game);
    }
    public Game getGame(){return game;}
}
