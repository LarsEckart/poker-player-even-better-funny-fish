package org.leanpoker.player;

import java.util.Arrays;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

public class Player {

    static final String VERSION = "Still fishy";

    public static int betRequest(JsonElement request) {
        try {
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();
            GameState gameState = gson.fromJson(request.toString(), GameState.class);


            PlayerDto ourPlayer = Arrays.stream(gameState.getPlayers()).filter(p -> p.getID() == gameState.getInAction()).findFirst().get();

            if (gameState.isPreFlop()) {
                int chenValue = ourPlayer.pocketCards().chenFormula();
                if (chenValue >= 9) {
                    return new PlayerStrategy().bet(gameState, ourPlayer);
                } else {
                    return 0;
                }
            }

            // current_buy_in - players[in_action][bet] + minimum_raise
            return new PlayerStrategy().bet(gameState, ourPlayer);
        } catch (Exception e) {
            return 100;
        }
    }

    public static void showdown(JsonElement game) {
    }
}
