package it.unicam.cs.mpgc.rpg129639.model.players;

public class NpcWithEffect extends Npc{
    private Parameters parameters;

    public NpcWithEffect(String name, String role, String quest) {
        super(name, role, quest);
        parameters = new Parameters();
    }

    public Parameters getParameters() {
        return parameters;
    }




}
