package it.unicam.rpg.model;

import it.unicam.rpg.model.data.CardLoader;
import it.unicam.rpg.model.players.Npc;
import it.unicam.rpg.model.players.Parameters;
import it.unicam.rpg.model.players.Player;
import it.unicam.rpg.model.players.User;

import java.util.List;

public abstract class GameContextSaveTranslator {
    public GameContextSave translateFromGame(Game game){
        GameContextSave saving = new GameContextSave();
        saving.loadDataFromGame(game);
        return saving;
    }
    public Game translateToGame(GameContextSave saving){
        String playerName = saving.getPlayerName();
        Parameters parameters = saving.getParameters();
        List<Npc> doneNpcs = saving.getDoneNpcs();
        List<Npc> allNpcs = CardLoader.LoadNpcs();

        //rimuovo dalla lista di tutte le carte, quelle già fatte
        for(Npc npc : doneNpcs){
            allNpcs.remove(npc);
        }

        return new Game(playerName, allNpcs, doneNpcs);

    }
}
