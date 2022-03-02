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
            var currentBuyIn = ourPlayer.getBet() + gameState.getMinimumRaise();
            long maxBet = ourPlayer.getStack()/3;

            // if we have 1 pair we increase our bet up to the maximum
            long bet = new PlayerStrategy().increaseBetIfWeGetPair(Arrays.asList(ourPlayer.getHoleCards()),
                    Arrays.asList(gameState.getCommunityCards()));
            currentBuyIn += bet;


            if (currentBuyIn > maxBet) {
                currentBuyIn = Math.toIntExact(maxBet);
            }

            return Math.toIntExact(currentBuyIn);
        } catch (Exception e) {
            return 100;
        }
    }

    public static void showdown(JsonElement game) {
    }
}
