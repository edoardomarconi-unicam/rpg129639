package it.unicam.rpg.model.data;

import com.google.gson.*;
import it.unicam.rpg.model.GameContextSave;

import java.io.*;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.Path;


public class GameSaverReader{
    private GameContextSave saving;
    private static final Path SAVE_FILE = Path.of("saves", "gameSave.json");
    private static final Path SAVE_DIRECTORY = Path.of("saves");

    public GameSaverReader(GameContextSave saving){
        this.saving = this.saving;
    }

    public GameContextSave loadSavedGame(){
        if(!SAVE_FILE.toFile().exists()){return null;}
        else{
            try{
                saving = new Gson().fromJson(new BufferedReader(Files.newBufferedReader(SAVE_FILE)), GameContextSave.class);
            }catch(IOException e){
                System.out.println("Error in loading game");
                e.printStackTrace();
            }
        }
        return saving;
    }

    public boolean saveGame(){
        if(!SAVE_DIRECTORY.toFile().exists()){
            try {
                Files.createDirectories(SAVE_DIRECTORY);
            } catch (IOException e) {
                System.out.println("Error in creating saving directory");
                e.printStackTrace();
            }
        }
        if(!SAVE_FILE.toFile().exists()){
            try{
                File saveFile = new File(SAVE_FILE.toUri());
                saveFile.createNewFile();
                FileWriter writer = new FileWriter(saveFile);
                writer.write(new Gson().toJson(saving));
                writer.close();
            }catch(IOException e){
                System.out.println("Error in saving game");
                e.printStackTrace();
            }
            return true;

        } else{
            try{
                FileWriter fileWriter = new FileWriter(SAVE_FILE.toFile());
                fileWriter.write(new Gson().toJson(saving));
                return true;
            }catch(IOException e){
                System.out.println("Error in saving game");
                e.printStackTrace();
            }
            return true;
        }
    }
}
