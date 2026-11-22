package it.unicam.rpg.view.playerDataInput;

import it.unicam.rpg.controller.PlayerDataInputController;
import it.unicam.rpg.view.ViewNavigator;
import it.unicam.rpg.view.settings.Screen;

public class PlayerDataInputScreen extends Screen<PlayerDataInputScene> {
    protected PlayerDataInputScene createView(){
         return new PlayerDataInputScene();
     }

     protected void createController(PlayerDataInputScene view, ViewNavigator viewNavigator){
         new PlayerDataInputController(view, viewNavigator);
     }
}
