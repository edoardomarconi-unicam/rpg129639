package it.unicam.cs.mpgc.rpg129639.model.settings;

public class Settings {
    private Difficulty difficulty = Difficulty.NORMAL;

    public  Settings(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Settings() {}

    public Difficulty getDifficulty() {
        return difficulty;
    }
}
