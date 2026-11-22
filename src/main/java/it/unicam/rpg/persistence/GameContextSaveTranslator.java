package it.unicam.rpg.persistence;

import it.unicam.rpg.model.Game;
import it.unicam.rpg.model.players.Npc;
import it.unicam.rpg.model.players.Parameters;

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
        List<Npc> allNpcs = CardLoader.LoadNpcs();

        //rimuovo dalla lista di tutte le carte, quelle già fatte
        for(Npc npc : doneNpcs){
            allNpcs.remove(npc);
        }
        Game game = new Game(playerName, allNpcs, doneNpcs);
        game.getUser().setParameters(parameters);
        return game;

    }
}
