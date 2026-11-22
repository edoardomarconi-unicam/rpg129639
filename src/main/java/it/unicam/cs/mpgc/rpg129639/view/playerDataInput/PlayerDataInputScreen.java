package it.unicam.cs.mpgc.rpg129639.view.playerDataInput;

import it.unicam.cs.mpgc.rpg129639.controller.PlayerDataInputController;
import it.unicam.cs.mpgc.rpg129639.view.ViewNavigator;
import it.unicam.cs.mpgc.rpg129639.view.Screen;

public class PlayerDataInputScreen extends Screen<PlayerDataInputScene> {
    protected PlayerDataInputScene createView(){
         return new PlayerDataInputScene();
     }

     protected void createController(PlayerDataInputScene view, ViewNavigator viewNavigator){
         new PlayerDataInputController(view, viewNavigator);
     }
}
