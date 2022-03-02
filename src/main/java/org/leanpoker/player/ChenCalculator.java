package org.leanpoker.player;

import java.util.List;

public class ChenCalculator {

    public static int calculate(List<Card> cards) {
        int result = 0;
        PreFlopHand preFlopHand = new PreFlopHand(cards);

        double halfRank = preFlopHand.getHigherCard().getRankAsInt() / 2.0;
        if (preFlopHand.getHigherCard().getSuit().equals(preFlopHand.getLowerCard().getSuit())) {
            result += 2;
        }
        int i = (int) Math.ceil(halfRank);
        result = result + i;
        return result;
    }

}
