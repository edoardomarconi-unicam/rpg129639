package it.unicam.rpg.view;

import it.unicam.rpg.controller.MainMenuController;
import it.unicam.rpg.model.ViewNavigator;

public class MainMenuScreen extends Screen<MainMenuScene>{
    @Override
    protected MainMenuScene createView() {
        return new MainMenuScene();
    }

    protected void createController(MainMenuScene mainMenuScene, ViewNavigator viewNavigator){
        new MainMenuController(mainMenuScene, viewNavigator);
    }
}
