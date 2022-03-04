package org.leanpoker.player;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

public class Player {

    private static final Gson GSON = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();
    static final String VERSION = "omg we folded on a potential full house";

    public static int betRequest(JsonElement request) {
        try {
            GameState gameState = GSON.fromJson(request.toString(), GameState.class);

            PlayerStrategy playerStrategy = new PlayerStrategy();
            return playerStrategy.doSomething(gameState);
        } catch (Exception e) {
            return 100;
        }
    }

    public static void showdown(JsonElement game) {
    }
}
