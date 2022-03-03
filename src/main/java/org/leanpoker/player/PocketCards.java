package org.leanpoker.player;

import java.util.List;

class PocketCards {

    private final Card higherCard;
    private final Card lowerCard;

    public PocketCards(List<Card> cards) {
        if (cards.get(0).getRankAsInt() > cards.get(1).getRankAsInt()) {
            higherCard = cards.get(0);
            lowerCard = cards.get(1);
        } else {
            higherCard = cards.get(1);
            lowerCard = cards.get(0);
        }
    }

    public int chenFormula() {
        double result = 0.0;

        result += scoreHighestCard();

        if (isPair()) {
            result = result * 2;
        }

        if (isSuited()) {
            result += 2;
        }

        result = result + gapValue();

        result += bonusPoint();

        return Math.toIntExact(Math.round(result));
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

    public boolean isPair() {
        return higherCard.getRank().equals(lowerCard.getRank());
    }

    public boolean isSuited() {
        return higherCard.getSuit().equals(lowerCard.getSuit());
    }

    public int gap() {
        if (higherCard.getRank().equals(lowerCard.getRank())) {
            return 0;
        }

        return higherCard.getRankAsInt() - lowerCard.getRankAsInt() - 1;
    }

    public int gapValue() {
        if (gap() <= 2) {
            return -gap();
        } else if (gap() == 3) {
            return -4;
        } else {
            return -5;
        }
    }

    public int bonusPoint() {
        if (isPair()) {
            return 0;
        }
        if ((gap() == 0 || gap() == 1) && higherCard.getRankAsInt() < 12) {
            return 1;
        }
        return 0;
    }
}
