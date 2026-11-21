package it.unicam.rpg.controller;

import it.unicam.rpg.model.Settings;
import it.unicam.rpg.model.ViewNavigator;
import it.unicam.rpg.model.data.GameSaverReader;
import it.unicam.rpg.model.data.SettingsLoaderSaver;
import it.unicam.rpg.view.Screen;
import it.unicam.rpg.view.SettingsView;

public class SettingsController{
    SettingsView settingsView;
    ViewNavigator viewNavigator;
    Screen<?> previusScreen;

    public SettingsController(SettingsView settingsView, ViewNavigator viewNavigator, Screen<?> previusScreen) {
        this.settingsView = settingsView;
        this.viewNavigator = viewNavigator;
        this.previusScreen = previusScreen;
    }

    public void settingsButtonsActions(Screen<?> previusScreen) {
        settingsView.setOnBack(() -> {
            viewNavigator.NavigateTo(previusScreen);
        });

        settingsView.setOnDifficultyChanged((difficulty) -> {
            new SettingsLoaderSaver().save(new Settings(difficulty));
        });

        settingsView.setOnDeleteSaves(() -> {
            new GameSaverReader().deleteAllSaves();
        });

    }
}
