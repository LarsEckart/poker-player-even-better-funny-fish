package org.leanpoker.player;

import java.util.List;

public class ChenCalculator {

    public static int calculate(List<Card> cards) {
        int result = 0;
        Card higherCard = cards.get(1);
        int rank = Integer.parseInt(higherCard.getRank());
        double halfRank = rank / 2.0;
        if (higherCard.getSuit().equals(cards.get(0).getSuit())) {
            result += 2;
        }
        int i = (int) Math.ceil(halfRank);
        result = result + i;
        return result;
    }
}
