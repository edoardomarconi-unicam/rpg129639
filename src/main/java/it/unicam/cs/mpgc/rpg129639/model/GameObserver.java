package it.unicam.cs.mpgc.rpg129639.model;

import it.unicam.cs.mpgc.rpg129639.model.players.Npc;
import it.unicam.cs.mpgc.rpg129639.model.players.User;

public interface GameObserver {
    default public void parameterChanged(User user){};
    default public void loadedNewCard(Npc npc){};
    default public void gameOver(String reason){};
}
