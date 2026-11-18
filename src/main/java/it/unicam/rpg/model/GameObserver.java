package it.unicam.rpg.model;

import it.unicam.rpg.model.players.Npc;
import it.unicam.rpg.model.players.User;

public interface GameObserver {
    default public void parameterChanged(User user){};
    default public void loadedNewCard(Npc npc){};
    default public void gameOver(String reason){};
}
