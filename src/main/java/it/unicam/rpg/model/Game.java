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
    public List<Npc> npcs = CardLoader.LoadNpcs();

    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    public void choose(Direction direction, User user) {
        Map<ParameterType, Integer> userParameters = user.getParameters().getValues();

        //verifico il game over per terminazione carte
        if(npcs.isEmpty()){
            observers.iterator().forEachRemaining(observer -> {observer.gameOver("Carte finite.");});
        }else{
            effectApplicator.application(user, npcs.getFirst(), direction);
        }

        //verifico il gameOver per raggiungimento valori limite parametri
        for(Map.Entry<ParameterType, Integer> entry : userParameters.entrySet()) {
            if(entry.getKey().lossValueReached(entry.getValue())) {
                observers.iterator().forEachRemaining(observer -> {observer.gameOver(entry.getKey().toString());});
            };
        }

        //elimino l'attuale carta dalla Map
        npcs.removeFirst();

        //carico una nuova carta
        if(!npcs.isEmpty())
            observers.iterator().forEachRemaining(observer -> {observer.loadedNewCard(npcs.getFirst());});

    }
}

