package it.unicam.cs.mpgc.rpg129639.view.settings;

import it.unicam.cs.mpgc.rpg129639.controller.SettingsController;
import it.unicam.cs.mpgc.rpg129639.view.Screen;
import it.unicam.cs.mpgc.rpg129639.view.ViewNavigator;

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
