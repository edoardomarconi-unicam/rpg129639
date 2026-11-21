package it.unicam.rpg.model;

import it.unicam.rpg.model.players.Npc;
import it.unicam.rpg.model.players.User;

public interface GameObserver {
    public void parameterChanged(User user);
    public void loadedNewCard(Npc npc);
    public void gameOver(String reason);
}
