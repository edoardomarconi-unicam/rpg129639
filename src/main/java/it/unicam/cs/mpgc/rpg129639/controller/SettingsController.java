package it.unicam.cs.mpgc.rpg129639.controller;

import it.unicam.cs.mpgc.rpg129639.model.settings.Settings;
import it.unicam.cs.mpgc.rpg129639.view.ViewNavigator;
import it.unicam.cs.mpgc.rpg129639.persistence.GameSaverReader;
import it.unicam.cs.mpgc.rpg129639.persistence.SettingsLoaderSaver;
import it.unicam.cs.mpgc.rpg129639.view.settings.SettingsView;

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
