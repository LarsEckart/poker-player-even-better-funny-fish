package org.leanpoker.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlayerStrategy {
    public long increaseBetIfWeGetPair(List<Card> holeCards, List<Card> communityCards) {
        System.err.println("PlayerStrategy.increaseBetIfWeGetPair, holeCards = " + holeCards+", communityCards = " + communityCards);
        List<Card> combinedCards = new ArrayList<>();
        combinedCards.addAll(holeCards);
        combinedCards.addAll(communityCards);
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

    private boolean doWeHavePairs(Map<String, Integer> rankCount) {
        List<Integer> numPairs = rankCount.values().stream().filter(count -> count == 2).collect(Collectors.toList());
        return numPairs.size() >= 1;
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
