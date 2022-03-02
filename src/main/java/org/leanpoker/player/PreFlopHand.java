package org.leanpoker.player;

import java.util.List;

class PreFlopHand {

    Card higherCard;
    Card lowerCard;

    public PreFlopHand(List<Card> cards) {
        if (cards.get(0).getRankAsInt() > cards.get(1).getRankAsInt()) {
            higherCard = cards.get(0);
            lowerCard = cards.get(1);
        } else {
            higherCard = cards.get(1);
            lowerCard = cards.get(0);
        }
    }

    public Card getHigherCard() {
        return higherCard;
    }

    public Card getLowerCard() {
        return lowerCard;
    }

    public double scoreHighestCard() {
        return switch (higherCard.getRank()) {
            case "A" -> 10;
            case "K" -> 8;
            case "Q" -> 7;
            case "J" -> 6;
            default -> higherCard.getRankAsInt() / 2.0;
        };
    }
}
