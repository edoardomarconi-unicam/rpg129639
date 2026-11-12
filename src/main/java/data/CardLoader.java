package data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import players.Npc;
import players.NpcWithEffect;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CardLoader {
    public static final Gson GSON_BUILDER = new GsonBuilder().registerTypeAdapter(Npc.class, new NpcSerializerDeserializer())
                                                    .setPrettyPrinting()
                                                    .create();
    public static final Gson gson = new Gson();
    public static List<Npc> LoadNpcs() {
        InputStream inputStreamFromCardsFile = CardLoader.class.getResourceAsStream("cards.json");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStreamFromCardsFile));

        List<Npc> npc = GSON_BUILDER.fromJson(reader, new TypeToken<List<Npc>>() {}.getType());
        return npc;
    }
}
