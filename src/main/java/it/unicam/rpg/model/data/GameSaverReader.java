package it.unicam.rpg.model.data;

import com.google.gson.stream.JsonReader;
import it.unicam.rpg.model.Game;
import com.google.gson.*;

import java.io.*;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.Path;


public class GameSaverReader{
    private Game game;
    private static final Path SAVE_FILE = Path.of("saves", "gameSave.json");

    public GameSaverReader(Game game){
        this.game = game;
    }

    public Game loadSavedGame(){
        if(!SAVE_FILE.toFile().exists()){return null;}
        else{
            try{
                game = new Gson().fromJson(new BufferedReader(Files.newBufferedReader(SAVE_FILE)), Game.class);
            }catch(IOException e){
                System.out.println("Error in loading game");
                e.printStackTrace();
            }
        }
        return game;
    }

    public boolean saveGame(){

        if(!SAVE_FILE.toFile().exists()){
            try{
                File saveFile = new File(SAVE_FILE.toUri());
                saveFile.createNewFile();
                FileWriter writer = new FileWriter(saveFile);
                writer.write(new Gson().toJson(game));
            }catch(IOException e){
                System.out.println("Error in saving game");
                e.printStackTrace();
            }
            return true;

        }
        else{
            try{
                FileWriter fileWriter = new FileWriter(SAVE_FILE.toFile());
                fileWriter.write(new Gson().toJson(game));
                return true;
            }catch(IOException e){
                System.out.println("Error in saving game");
                e.printStackTrace();
            }
            return true;
        }
    }
}
