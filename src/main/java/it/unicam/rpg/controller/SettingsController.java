package it.unicam.rpg.controller;

import it.unicam.rpg.model.ViewNavigator;
import it.unicam.rpg.view.Screen;
import it.unicam.rpg.view.SettingsView;
import javafx.scene.Scene;

public class SettingsController{
    SettingsView settingsView;
    ViewNavigator viewNavigator;
    Screen<?> previusScene;

    public SettingsController(SettingsView settingsView, ViewNavigator viewNavigator, Screen<?> previusScene) {
        this.settingsView = settingsView;
        this.viewNavigator = viewNavigator;
        this.previusScene = previusScene;
    }
}
