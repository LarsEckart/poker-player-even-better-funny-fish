package org.leanpoker.player;

import java.util.List;

public class ChenCalculator {

    public static int calculate(List<Card> cards) {
        double result = 0.0;
        PreFlopHand preFlopHand = new PreFlopHand(cards);

        result += preFlopHand.scoreHighestCard();
        if (preFlopHand.isPair()) {
            result = result * 2;
        }
        if (preFlopHand.isSuited()) {
            result += 2;
        }

        result = result + preFlopHand.gapValue();

        result += preFlopHand.bonusPoint();

        long roundedUp = Math.round(result);
        return Math.toIntExact(roundedUp);
    }

}
