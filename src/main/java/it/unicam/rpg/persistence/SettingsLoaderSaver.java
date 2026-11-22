package it.unicam.rpg.persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import it.unicam.rpg.model.settings.Settings;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class SettingsLoaderSaver {
    //cartella separata da "saves" perchè almeno cancellando i salvataggi le impostazioni restano
    private static final Path SETTINGS_FILE = Path.of("config", "settings.json");
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public Settings load() {
        if (!Files.exists(SETTINGS_FILE)) return new Settings();
        try (Reader reader = Files.newBufferedReader(SETTINGS_FILE)) {
            Settings settings = GSON.fromJson(reader, Settings.class);
            return settings != null ? settings : new Settings();
        } catch (IOException | JsonParseException e) {
            System.out.println("Error loading settings.");
            e.printStackTrace();
            return new Settings();
        }
    }

    public boolean save(Settings settings) {
        try {
            Files.createDirectories(SETTINGS_FILE.getParent());
            Files.writeString(SETTINGS_FILE, GSON.toJson(settings));
            return true;
        } catch (IOException e) {
            System.out.println("Error saving settings.");
            e.printStackTrace();
            return false;
        }
    }
}
