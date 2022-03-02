package org.leanpoker.player;

import java.util.Arrays;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;

public class Player {

    static final String VERSION = "Still fishy";

    public static int betRequest(JsonElement request) {
        try {
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();
            GameState gameState = gson.fromJson(request.toString(), GameState.class);


            PlayerDto ourPlayer = Arrays.stream(gameState.getPlayers()).filter(p -> p.getID() == gameState.getInAction()).findFirst().get();

            // current_buy_in - players[in_action][bet] + minimum_raise
            var result = ourPlayer.getBet() + gameState.getMinimumRaise();

            // TODO: set a max ?
            return Math.toIntExact(result);
        } catch (Exception e) {
            return 100;
        }
    }

    public static void showdown(JsonElement game) {
    }
}
