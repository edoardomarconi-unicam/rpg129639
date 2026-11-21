package it.unicam.rpg.controller;

import it.unicam.rpg.model.ViewNavigator;
import it.unicam.rpg.view.Screen;
import it.unicam.rpg.view.SettingsView;

public class SettingsController{
    SettingsView settingsView;
    ViewNavigator viewNavigator;
    Screen previusScreen;

    public SettingsController(SettingsView settingsView, ViewNavigator viewNavigator, Screen <?> previusScreen) {
        this.settingsView = settingsView;
        this.viewNavigator = viewNavigator;
        this.previusScreen = previusScreen;
    }
}
