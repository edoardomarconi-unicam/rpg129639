package it.unicam.rpg.model;

import it.unicam.rpg.model.players.Npc;
import it.unicam.rpg.model.players.Parameters;
import java.util.*;

public class GameContextSave {
    private String playerName = "";
    private Parameters parameters;
    private List<Npc> doneNpcs = new ArrayList<>();


    public void loadDataFromGame(Game game){
        playerName = game.getUser().getName();
        parameters = game.getUser().getParameters();
        doneNpcs = game.getDoneNpcs();
    }

    public String getPlayerName() {return playerName;}
    public Parameters getParameters() {return parameters;}
    public List<Npc> getDoneNpcs() {return doneNpcs;}
}
