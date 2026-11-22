package it.unicam.rpg.view;

import it.unicam.rpg.controller.SettingsController;
import it.unicam.rpg.model.ViewNavigator;
import javafx.scene.Scene;

public class SettingsScreen extends Screen<SettingsView>{
    private SettingsView settingsView;
    private ViewNavigator viewNavigator;

    protected SettingsView createView(){
        return new SettingsView();
    }

    protected void createController(SettingsView settingsView, ViewNavigator viewNavigator) {
        new SettingsController(settingsView, viewNavigator);
    }
}
