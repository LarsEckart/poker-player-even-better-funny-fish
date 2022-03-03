package org.leanpoker.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerStrategy {

    int bet(GameState gameState, PlayerDto ourPlayer) {
        var currentBuyIn = ourPlayer.getBet() + gameState.getMinimumRaise();
        long maxBet = ourPlayer.getStack()/3;
        List<Card> combinedCards = allCards(ourPlayer.pocketCardsAsList(), Arrays.asList(gameState.getCommunityCards()));

        if (doWeHave4OfAKind(getRankCount(combinedCards))) {
            return Math.toIntExact(ourPlayer.getStack());
        }
        // if we have 1 pair we increase our bet up to the maximum
        long bet = increaseBetIfWeGetPair(
                ourPlayer.pocketCardsAsList(),
                Arrays.asList(gameState.getCommunityCards()),
                combinedCards);
        currentBuyIn += bet;

        if (currentBuyIn > maxBet) {
            currentBuyIn = Math.toIntExact(maxBet);
        }

        return Math.toIntExact(currentBuyIn);
    }

    public long increaseBetIfWeGetPair(List<Card> holeCards, List<Card> communityCards, List<Card> combinedCards) {
        System.err.println("PlayerStrategy.increaseBetIfWeGetPair, holeCards = " + holeCards+", communityCards = " + communityCards);
        Map<String, Integer> rankCount = getRankCount(combinedCards);
        System.err.println("rankCounts = " + rankCount);
        boolean isTherePairs = doWeHavePairs(rankCount);
        // [{"K", "spades"},{"K", "clubs"}] => {"K": 2}
        // count the number of ranks has the rank
        // make the map where the rank is key
        if (isTherePairs)
            return 100;
        return 0;
    }

    private List<Card> allCards(List<Card> holeCards, List<Card> communityCards) {
        List<Card> combinedCards = new ArrayList<>();
        combinedCards.addAll(holeCards);
        combinedCards.addAll(communityCards);
        return combinedCards;
    }

    private boolean doWeHavePairs(Map<String, Integer> rankCount) {
        return rankCount.values().stream().anyMatch(count -> count == 2);
    }
    private boolean doWeHave4OfAKind(Map<String, Integer> rankCount) {
        return rankCount.values().stream().anyMatch(count -> count == 4);
    }

    private Map<String, Integer> getRankCount(List<Card> combinedCards) {
        Map<String, Integer> rankCount = new HashMap<>();
        for (Card card: combinedCards) {
            String rank = card.getRank();
            if(rankCount.containsKey(rank)) {
                rankCount.put(rank, rankCount.get(rank) + 1);
            } else {
                rankCount.put(rank, 1);
            }
        }
        return rankCount;
    }
}
