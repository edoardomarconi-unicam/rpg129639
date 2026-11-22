package it.unicam.cs.mpgc.rpg129639.view.mainMenu;

import it.unicam.cs.mpgc.rpg129639.controller.MainMenuController;
import it.unicam.cs.mpgc.rpg129639.view.ViewNavigator;
import it.unicam.cs.mpgc.rpg129639.view.Screen;

public class MainMenuScreen extends Screen<MainMenuScene> {
    @Override
    protected MainMenuScene createView() {
        return new MainMenuScene();
    }

    protected void createController(MainMenuScene mainMenuScene, ViewNavigator viewNavigator){
        new MainMenuController(mainMenuScene, viewNavigator);
    }
}
