package it.unicam.rpg.model;

import java.util.ArrayList;
import java.util.List;
import it.unicam.rpg.model.players.*;
public class Game {
    private List<GameObserver> observers = new ArrayList<GameObserver>();
    private ChoiceEffectApplicator effectApplicator = new ChoiceEffectApplicator();

    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    public void choose(Direction direction, User user, Npc npc) {
        effectApplicator.application(user, npc, direction);
        if(!user.getParameters().lossReasons().isEmpty()){
            for(GameObserver observer : observers){
                observer.gameOver("Ha superato la soglia di sopportazione di  ");

            }
        }

    }


}
