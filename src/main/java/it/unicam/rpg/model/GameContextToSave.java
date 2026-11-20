package it.unicam.rpg.model;

import it.unicam.rpg.model.players.Npc;

import java.util.*;

public class GameContextSaved {
    private String playerName = "";
    private Map<ParameterType, Integer> userParameters = new EnumMap<>(ParameterType.class);
    private List<Npc> doneNpcs = new ArrayList<>();


    public void getDataFromGame(Game game){
        playerName = game.getUser().getName();
        player
    }
}
