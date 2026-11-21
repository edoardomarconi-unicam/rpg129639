package it.unicam.rpg.model.data;

import com.google.gson.*;
import it.unicam.rpg.model.players.Npc;
import it.unicam.rpg.model.players.NpcWithEffect;
import it.unicam.rpg.model.players.NpcWithNoEffect;

import java.lang.reflect.Type;

public class NpcSerializerDeserializer implements JsonDeserializer<Npc>{
    /*public JsonElement serialize(Npc npc, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = context.serialize(npc, npc.getClass()).getAsJsonObject();
        jsonObject.addProperty("type", npc.getClass().getSimpleName());

        return jsonObject;
    }*/

    @Override
    public Npc deserialize(JsonElement npc, Type typeOfSrc, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = npc.getAsJsonObject();

        JsonElement typeElement = jsonObject.get("type");

        if(typeElement == null) {
            throw new JsonParseException("NPC non assegnato ad alcuna tipologia");
        }

        String type = typeElement.getAsString();

        switch (type) {
            case "with-effect":
                return context.deserialize(npc, NpcWithEffect.class);
            case "no-effect":
                return context.deserialize(npc, NpcWithNoEffect.class);
            default:
                throw new JsonParseException("Tipologia di NPC non riconosciuta");
        }

    }
}
