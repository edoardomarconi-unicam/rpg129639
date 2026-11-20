package it.unicam.rpg.view;

import it.unicam.rpg.controller.PauseMenuController;
import it.unicam.rpg.model.ViewNavigator;

public class PauseMenuScreen extends Screen<PauseMenuView> {
    protected PauseMenuView createView(){
        return new PauseMenuView();
    }
    protected void createController(PauseMenuView view, ViewNavigator viewNavigator){
        new PauseMenuController(view, viewNavigator);
    }
}
