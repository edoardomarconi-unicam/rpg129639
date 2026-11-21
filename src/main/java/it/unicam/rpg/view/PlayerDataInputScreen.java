package it.unicam.rpg.view;

import it.unicam.rpg.controller.PlayerDataInputController;
import it.unicam.rpg.model.ViewNavigator;

public class PlayerDataInputScreen extends Screen<PlayerDataInputScene>{
    protected PlayerDataInputScene createView(){
         return new PlayerDataInputScene();
     }

     protected void createController(PlayerDataInputScene view, ViewNavigator viewNavigator){
         new PlayerDataInputController(view, viewNavigator);
     }
}
