package it.unicam.cs.mpgc.rpg129639.model.players;

public abstract class Player {
    private String name;
    private String role;

    public Player(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {return name;}
    public String getRole() {return role;}
}
