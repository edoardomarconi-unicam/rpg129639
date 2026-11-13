package it.unicam.rpg.model.players;

import java.io.Serializable;

public abstract class Npc extends Player implements Serializable {
    public String quest;

    public Npc(String name, String role){
        super(name, role);
    }
    public abstract Parameters getParameters();

}
