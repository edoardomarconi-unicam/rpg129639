package it.unicam.rpg.model;

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
