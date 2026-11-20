package it.unicam.rpg.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import it.unicam.rpg.model.data.CardLoader;
import it.unicam.rpg.model.players.*;
//TODO finire implementazione Game, sistemare la sezione del game over
//TODO ricordati di rimettere la lista degli npcs nuovamente privata una volta finito con le prove
public class Game {
    private List<GameObserver> observers = new ArrayList<GameObserver>();
    private ChoiceEffectApplicator effectApplicator = new ChoiceEffectApplicator();
    private List<Npc> npcs;
    private List<Npc> doneNpcs;
    private User user;

    public Game(User user){
        this.user = user;
        npcs = CardLoader.LoadNpcs();
    }

    public Game(String playerName){
        user = new User(playerName, "Player");
        npcs = CardLoader.LoadNpcs();
    }

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
                    observers.iterator().forEachRemaining(observer -> {observer.gameOver(entry.getKey().toString());});
                };
            }

            //elimino l'attuale carta dalla Map
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



    //getter
    public  List<Npc> getNpcs(){return npcs;}
    public Npc getCurrentNpc(){return npcs.getFirst();}
    public List<Npc> getDoneNpcs(){return doneNpcs;}
    public User getUser(){return user;}
}

