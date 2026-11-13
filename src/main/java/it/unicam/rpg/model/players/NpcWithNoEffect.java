package it.unicam.rpg.model.players;

public class NpcWithNoEffect extends Npc{
    public NpcWithNoEffect(String name, String role, int health, int education, int fear, int brotherhood){
        super(name, role);
    }

    public Parameters getParameters() {
        return null;
    }
}
