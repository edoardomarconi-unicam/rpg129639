package it.unicam.rpg.model;

import com.google.gson.annotations.SerializedName;

public enum ParameterType {
    @SerializedName("brotherhood") BROTHERHOOD("Legame con la vita di strada", 100, true),
    @SerializedName("fear") FEAR("Paura", 100, true),
    @SerializedName("health") HEALTH("Salute", 0, false),
    @SerializedName("education") EDUCATION("Istruzione", 0, false);




    //afterOrBeforeLossValue indica che non bisogna superarlo se true, altrimenti indica che non bisogna essere sotto
    private final String description;
    private final int lossValue;
    private final boolean afterLossValue;


    ParameterType(String description, int lossValue, boolean afterLossValue) {
        this.description = description;
        this.lossValue = lossValue;
        this.afterLossValue = afterLossValue;
    }

    public boolean lossValueReached(int lossValue){
        if(this.afterLossValue)
            return lossValue >= this.lossValue;
        else
            return lossValue <= this.lossValue;
    }

    public String getDescription(){
        return "Partita terminata perche il valore " + description + " ha raggiunto il massimo di sopportazione";
    }
}
