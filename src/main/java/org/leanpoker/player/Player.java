package org.leanpoker.player;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

public class Player {

    static final String VERSION = "Smart fish?";

    public static int betRequest(JsonElement request) {
        try {
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();
            GameState gameState = gson.fromJson(request.toString(), GameState.class);

            PlayerDto ourPlayer = gameState.getOurPlayer();

            PlayerStrategy playerStrategy = new PlayerStrategy();
            return playerStrategy.doSomething(gameState, ourPlayer);
        } catch (Exception e) {
            return 100;
        }
    }

    public static void showdown(JsonElement game) {
    }
}
