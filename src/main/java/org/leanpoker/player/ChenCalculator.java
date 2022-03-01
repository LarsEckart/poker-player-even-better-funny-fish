package org.leanpoker.player;

import java.util.List;

public class ChenCalculator {

    public static int calculate(List<Card> cards) {
        int result = 0;
        Card higherCard;
        Card lowerCard;
        if (cards.get(0).getRankAsInt() > cards.get(1).getRankAsInt()) {
            higherCard = cards.get(0);
            lowerCard = cards.get(1);
        } else {
            higherCard = cards.get(1);
            lowerCard = cards.get(0);
        }
        double halfRank = higherCard.getRankAsInt() / 2.0;
        if (higherCard.getSuit().equals(lowerCard.getSuit())) {
            result += 2;
        }
        int i = (int) Math.ceil(halfRank);
        result = result + i;
        return result;
    }
}
