package it.unicam.cs.mpgc.rpg129639.persistence;

import it.unicam.cs.mpgc.rpg129639.model.Game;
import it.unicam.cs.mpgc.rpg129639.model.players.Npc;
import it.unicam.cs.mpgc.rpg129639.model.players.Parameters;
import java.util.*;

public class GameContextSave {
    private String playerName = "";
    private Parameters parameters;
    private List<Npc> doneNpcs = new ArrayList<>();
    private List<Npc> npcsInOrder = new ArrayList<>();


    public void loadDataFromGame(Game game){
        playerName = game.getUser().getName();
        parameters = game.getUser().getParameters();
        npcsInOrder = game.getNpcs();
        doneNpcs = game.getDoneNpcs();
    }

    public String getPlayerName() {return playerName;}
    public Parameters getParameters() {return parameters;}
    public List<Npc> getDoneNpcs() {return doneNpcs;}
    public List<Npc> getNpcsInOrder() {return npcsInOrder;}
}
