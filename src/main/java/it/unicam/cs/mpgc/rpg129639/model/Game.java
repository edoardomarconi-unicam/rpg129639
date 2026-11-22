package it.unicam.cs.mpgc.rpg129639.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import it.unicam.cs.mpgc.rpg129639.model.card.ChoiceEffectApplicator;
import it.unicam.cs.mpgc.rpg129639.model.card.ParameterType;
import it.unicam.cs.mpgc.rpg129639.model.players.Npc;
import it.unicam.cs.mpgc.rpg129639.model.players.User;
import it.unicam.cs.mpgc.rpg129639.model.settings.Difficulty;
import it.unicam.cs.mpgc.rpg129639.persistence.CardLoader;
import it.unicam.cs.mpgc.rpg129639.persistence.SettingsLoaderSaver;
import it.unicam.cs.mpgc.rpg129639.model.players.*;

public class Game {
    private List<GameObserver> observers = new ArrayList<GameObserver>();
    private ChoiceEffectApplicator effectApplicator = new ChoiceEffectApplicator(new SettingsLoaderSaver().load().getDifficulty());
    private List<Npc> npcs;
    private List<Npc> doneNpcs;
    private User user;

    public Game(User user){
        this.user = user;
        npcs = CardLoader.LoadNpcs();
        Collections.shuffle(npcs);
        doneNpcs = new ArrayList<>();
    }

    //costruttore di una nuova partita
    public Game(String playerName){
        user = new User(playerName, "Player");
        npcs = CardLoader.LoadNpcs();
        Collections.shuffle(npcs);
        doneNpcs = new ArrayList<>();
    }

    //costruttore di una partita caricata da salvataggio
    public Game(String playerName, List<Npc> npcs,  List<Npc> doneNpcs){
        user = new User(playerName, "Player");
        this.npcs = npcs;
        this.doneNpcs = doneNpcs;
    }

    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    public void choose(Direction direction, User user) {
        Map<ParameterType, Integer> userParameters = user.getParameters().getValues();

        //verifico il game over per terminazione carte
        if(npcs.isEmpty()){
            observers.forEach(observer -> {observer.gameOver("Carte finite.");});
        }else{
            effectApplicator.application(user, npcs.getFirst(), direction);
            observers.forEach(observer -> {observer.parameterChanged(this.user);});

            //verifico il gameOver per raggiungimento valori limite parametri
            for(Map.Entry<ParameterType, Integer> entry : userParameters.entrySet()) {
                if(entry.getKey().lossValueReached(entry.getValue())) {
                    observers.iterator().forEachRemaining(observer -> {observer.gameOver(entry.getKey().getDescription());});
                };
            }

            //elimino l'attuale carta dalla List
            doneNpcs.add(npcs.getFirst());
            npcs.removeFirst();

            //carico una nuova carta e nel caso npcs sia vuoto, chiamo il gameOver()
            if(!npcs.isEmpty()){
                observers.iterator().forEachRemaining(observer -> {observer.loadedNewCard(npcs.getFirst());});
            }else{
                observers.forEach(observer -> {observer.gameOver("Carte finite.");});
            }

        }
    }

    public void setDifficulty(Difficulty difficulty) {
        effectApplicator.difficultyChanged(difficulty);
    }


    //getter
    public  List<Npc> getNpcs(){return npcs;}
    public Npc getCurrentNpc(){return npcs.getFirst();}
    public List<Npc> getDoneNpcs(){return doneNpcs;}
    public User getUser(){return user;}
}

