package it.unicam.rpg.model.players;

public class NpcWithNoEffect extends Npc{
    public NpcWithNoEffect(String name, String role, String quest){
        super(name, role, quest);
    }

    public Parameters getParameters() {
        return null;
    }
}
