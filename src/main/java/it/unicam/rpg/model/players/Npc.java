package it.unicam.rpg.model.players;

import it.unicam.rpg.model.Choice;

import java.io.Serializable;

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

}
