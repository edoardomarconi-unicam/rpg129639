package it.unicam.rpg.model.players;

import it.unicam.rpg.model.Choice;

import java.io.Serializable;
import java.util.Objects;

public abstract class Npc extends Player implements Serializable {
    private String quest;
    private Choice right;
    private Choice left;

    public Npc(String name, String role, String quest){
        super(name, role);
        this.quest = quest;
    }

    public Choice getRight() {return right;}
    public Choice getLeft() {return left;}
    public String getQuest() {return quest;}

    public abstract Parameters getParameters();

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Npc npc)) return false;
        return Objects.equals(getName(), npc.getName())
                && Objects.equals(getRole(), npc.getRole())
                && Objects.equals(getQuest(), npc.getQuest())
                && Objects.equals(right, npc.right)
                && Objects.equals(left, npc.left);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getRole(), getQuest(), right, left);
    }
}
