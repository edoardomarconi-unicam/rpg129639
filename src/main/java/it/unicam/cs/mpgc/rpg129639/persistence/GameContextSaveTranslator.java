package it.unicam.cs.mpgc.rpg129639.persistence;

import it.unicam.cs.mpgc.rpg129639.model.Game;
import it.unicam.cs.mpgc.rpg129639.model.players.Npc;
import it.unicam.cs.mpgc.rpg129639.model.players.Parameters;

import java.util.List;

public abstract class GameContextSaveTranslator {

    public static GameContextSave translateFromGame(Game game){
        GameContextSave saving = new GameContextSave();
        saving.loadDataFromGame(game);
        return saving;
    }
    public static Game translateToGame(GameContextSave saving){
        String playerName = saving.getPlayerName();
        Parameters parameters = saving.getParameters();
        List<Npc> doneNpcs = saving.getDoneNpcs();
        List<Npc> allNpcs = saving.getNpcsInOrder();

        Game game = new Game(playerName, allNpcs, doneNpcs);
        game.getUser().setParameters(parameters);
        return game;

    }
}
