package it.unicam.rpg.model.players;

import it.unicam.rpg.model.card.ParameterType;

import java.util.EnumMap;
import java.util.Map;

//Tutti i parametri devono avere un valore >= 0 e <= 100
public class Parameters {
    private Map<ParameterType, Integer> values = new EnumMap<>(ParameterType.class);

    //costruttore per inizializzare lo user
    public Parameters() {
        values.put(ParameterType.HEALTH, 50);
        values.put(ParameterType.BROTHERHOOD, 50);
        values.put(ParameterType.EDUCATION, 50);
        values.put(ParameterType.FEAR, 50);
    }

    public boolean changeParameters(Map<ParameterType, Integer> npcEffectValues){
        boolean changed = false;
        for(Map.Entry<ParameterType, Integer> entry : npcEffectValues.entrySet()){
            if(values.containsKey(entry.getKey())){
                values.put(entry.getKey(), values.get(entry.getKey()) + entry.getValue());
                changed = true;
            }
        }
        return changed;
    }

    public Map<ParameterType, Integer> getValues() {return values;}

    @Override
    public String toString() {
        return "Parameters" + values;
    }
}
