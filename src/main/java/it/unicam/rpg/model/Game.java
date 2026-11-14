package it.unicam.rpg.model;

import java.util.ArrayList;
import java.util.List;
import it.unicam.rpg.model.players.*;
public class Game {
    private List<GameObserver> observers = new ArrayList<GameObserver>();

    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    public void choose(Direction direction, User user) {
        for (GameObserver observer : observers) observer.parameterChanged();
    }


}
