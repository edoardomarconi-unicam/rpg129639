package it.unicam.cs.mpgc.rpg129639.persistence;

import com.google.gson.*;
import it.unicam.cs.mpgc.rpg129639.model.players.Npc;

import java.io.*;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.Path;


public class GameSaverReader{
    private GameContextSave saving;
    private static final Path SAVE_FILE = Path.of("saves", "gameSave.json");
    private static final Path SAVE_DIRECTORY = Path.of("saves");
    public static final Gson GSON_BUILDER = new GsonBuilder().registerTypeAdapter(Npc.class, new NpcSerializerDeserializer())
            .setPrettyPrinting()
            .create();

    public GameSaverReader(GameContextSave saving){
        this.saving = saving;
    }
    public GameSaverReader(){}
    public GameContextSave loadSavedGame(){
        //gestisco anche l'eccezione JsonParseException perchè è quella sollevata da GSON_BUILDER
        if(!SAVE_FILE.toFile().exists()){return null;}
        else{
            try{
                saving = GSON_BUILDER.fromJson(new BufferedReader(Files.newBufferedReader(SAVE_FILE)), GameContextSave.class);
            }catch(IOException | JsonParseException e){
                System.out.println("Error in loading game");
                e.printStackTrace();
                return null;
            }
        }
        return saving;
    }

    public boolean saveGame(){
        //creazione della directory di salvataggio nel caso non esista
        if(!SAVE_DIRECTORY.toFile().exists()){
            try {
                Files.createDirectories(SAVE_DIRECTORY);
            } catch (IOException e) {
                System.out.println("Error in creating saving directory");
                e.printStackTrace();
                return false;
            }
        }

        //creazione e salvataggio del file
        if(!SAVE_FILE.toFile().exists()){
            try(FileWriter writer =  new FileWriter(SAVE_FILE.toFile())){
                File saveFile = new File(SAVE_FILE.toUri());
                saveFile.createNewFile();
                writer.write(GSON_BUILDER.toJson(saving));
                return true;
            }catch(IOException e){
                System.out.println("Error in saving game");
                e.printStackTrace();
                return false;
            }

        } else if(SAVE_FILE.toFile().exists()){
            try(FileWriter fileWriter = new FileWriter(SAVE_FILE.toFile());){
                fileWriter.write(GSON_BUILDER.toJson(saving));
                return true;
            }catch(IOException e){
                System.out.println("Error in saving game");
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public boolean deleteAllSaves(){
        if(SAVE_FILE.toFile().exists()){
            return new File(SAVE_FILE.toUri()).delete();
        }else{
            return false;
        }
    }
}
