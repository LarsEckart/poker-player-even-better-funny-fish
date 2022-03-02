package org.leanpoker.player;

public class Card {

    private String rank;
    private String suit;

    public String getRank() {
        return rank;
    }

    public int getRankAsInt() {
        return switch (rank) {
            case "J" -> 11;
            case "Q" -> 12;
            case "K" -> 13;
            case "A" -> 14;
            default -> Integer.parseInt(rank);
        };
    }

    public void setRank(String value) {
        this.rank = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String value) {
        this.suit = value;
    }
}
