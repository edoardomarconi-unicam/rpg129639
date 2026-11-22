package it.unicam.cs.mpgc.rpg129639.view.pauseMenu;

import it.unicam.cs.mpgc.rpg129639.controller.PauseMenuController;
import it.unicam.cs.mpgc.rpg129639.model.Game;
import it.unicam.cs.mpgc.rpg129639.view.ViewNavigator;
import it.unicam.cs.mpgc.rpg129639.view.Screen;

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
