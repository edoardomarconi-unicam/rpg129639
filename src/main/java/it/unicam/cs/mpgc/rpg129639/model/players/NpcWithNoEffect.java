package it.unicam.cs.mpgc.rpg129639.model.players;

public class NpcWithNoEffect extends Npc{
    public NpcWithNoEffect(String name, String role, String quest){
        super(name, role, quest);
    }

    public Parameters getParameters() {
        return null;
    }
}
