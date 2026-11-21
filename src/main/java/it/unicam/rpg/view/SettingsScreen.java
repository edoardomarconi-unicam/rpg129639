package it.unicam.rpg.view;

import com.sun.scenario.Settings;
import it.unicam.rpg.controller.SettingsController;
import it.unicam.rpg.model.ViewNavigator;
import javafx.scene.Scene;

public class SettingsScreen extends Screen<SettingsView>{
    private SettingsView settingsView;
    private ViewNavigator viewNavigator;
    private Screen<?> previusScreen;

    public SettingsScreen(SettingsView settingsView, ViewNavigator viewNavigator, Screen<?> previusScreen) {
        this.settingsView = settingsView;
        this.viewNavigator = viewNavigator;
        this.previusScreen = previusScreen;
    }

    protected SettingsView createView(){
        return new SettingsView();
    }

    protected void createController(SettingsView settingsView, ViewNavigator viewNavigator){
        new SettingsController(settingsView, viewNavigator, this.previusScreen);
    }
}
