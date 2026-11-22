package it.unicam.rpg.view.mainMenu;

import it.unicam.rpg.controller.MainMenuController;
import it.unicam.rpg.view.ViewNavigator;
import it.unicam.rpg.view.settings.Screen;

public class MainMenuScreen extends Screen<MainMenuScene> {
    @Override
    protected MainMenuScene createView() {
        return new MainMenuScene();
    }

    protected void createController(MainMenuScene mainMenuScene, ViewNavigator viewNavigator){
        new MainMenuController(mainMenuScene, viewNavigator);
    }
}
