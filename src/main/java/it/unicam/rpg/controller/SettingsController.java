package it.unicam.rpg.controller;

import it.unicam.rpg.model.Settings;
import it.unicam.rpg.model.ViewNavigator;
import it.unicam.rpg.data.GameSaverReader;
import it.unicam.rpg.data.SettingsLoaderSaver;
import it.unicam.rpg.view.SettingsView;

public class SettingsController{
    SettingsView settingsView;
    ViewNavigator viewNavigator;

    public SettingsController(SettingsView settingsView, ViewNavigator viewNavigator) {
        this.settingsView = settingsView;
        this.viewNavigator = viewNavigator;
        settingsButtonsActions();
    }

    public void settingsButtonsActions() {
        settingsView.setOnBack(() -> {
            viewNavigator.goBack();
        });

        settingsView.setOnDifficultyChanged((difficulty) -> {
            new SettingsLoaderSaver().save(new Settings(difficulty));
        });

        settingsView.setOnDeleteSaves(() -> {
            new GameSaverReader().deleteAllSaves();
        });

    }
}
