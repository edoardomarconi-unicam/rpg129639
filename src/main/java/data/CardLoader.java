package data;

import com.google.gson.Gson;
import players.Npc;
import players.NpcWithEffect;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CardLoader {
    public static final Gson GSON = new Gson();

    public static NpcWithEffect LoadNpcs() {
        InputStream inputStreamFromCardsFile = CardLoader.class.getResourceAsStream("cards.json");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStreamFromCardsFile));

        return GSON.fromJson(reader, NpcWithEffect.class);
    }
}
