package it.unicam.rpg.model.players;

import it.unicam.rpg.model.ParameterType;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Parameters {
    private Map<ParameterType, Integer> values = new EnumMap<>(ParameterType.class);

    //costruttore per inizializzare lo user
    public Parameters() {
        values.put(ParameterType.HEALTH, 50);
        values.put(ParameterType.BROTHERHOOD, 50);
        values.put(ParameterType.EDUCATION, 50);
        values.put(ParameterType.FEAR, 50);
    }





    /*all the parameters must be >= 0 e <=100*/

    /*private int health;
    private int education;
    private int fear;
    private int brotherhood;

    public Parameters() {
        this.health = 50;
        this.education = 50;
        this.fear = 50;
        this.brotherhood = 50;
    }

    public Parameters(int healt, int education, int fear, int brotherhood) {
        this.health = healt;
        this.education = education;
        this.fear = fear;
        this.brotherhood = brotherhood;
    }

    public int getHealth(){
        return this.health;
    }
    public int getEducation(){
        return this.education;
    }
    public int getFear(){
        return this.fear;
    }
    public int getBrotherhood(){
        return this.brotherhood;
    }

    public void changeAll(int changeHealt, int changeEducation, int changeFear, int changeBrotherhood) {
        this.health = changeHealt;
        this.education = changeEducation;
        this.fear = changeFear;
        this.brotherhood = changeBrotherhood;
    }

    public List<String> lossReasons(){
        List<String> lossParameters = new ArrayList<>();

        if(this.brotherhood >= 100) lossParameters.add("Legame con la strada");
        if(this.health <= 0) lossParameters.add("Salute");
        if(this.education <= 0) lossParameters.add("Istruzione");
        if(this.fear >= 100) lossParameters.add("Paura");

        return lossParameters;
    }*/



}
