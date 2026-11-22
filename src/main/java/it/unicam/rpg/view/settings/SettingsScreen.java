package it.unicam.rpg.view.settings;

import it.unicam.rpg.controller.SettingsController;
import it.unicam.rpg.view.Screen;
import it.unicam.rpg.view.ViewNavigator;

public class SettingsScreen extends Screen<SettingsView> {
    private SettingsView settingsView;
    private ViewNavigator viewNavigator;

    protected SettingsView createView(){
        return new SettingsView();
    }

    protected void createController(SettingsView settingsView, ViewNavigator viewNavigator) {
        new SettingsController(settingsView, viewNavigator);
    }
}
