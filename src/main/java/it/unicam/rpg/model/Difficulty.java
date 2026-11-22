package it.unicam.rpg.model;

public enum Difficulty {
    EASY ("Facile", 1.0),
    NORMAL("Normale", 2.0),
    HARD ("Difficile", 3.0);

    private final String label;
    private final double multiplier;

    Difficulty(String label, double multiplier) {
        this.label = label;
        this.multiplier = multiplier;
    }

    public int apply(int npcEffect){
        return (int) Math.round(npcEffect * multiplier);
    }

    //usato dalla ComboBox in SettingsView
    public String toString() {return label;}
}
