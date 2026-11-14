package it.unicam.rpg.model;

import it.unicam.rpg.model.players.Npc;

public interface GameObserver {
    public void parameterChanged(Direction direction);
    public void loadedNewCard(Npc npc);
    public void gameOver(String reason);
}
