package org.leanpoker.player;

public class Card {

    private String rank;
    private String suit;

    public String getRank() {
        return rank;
    }

    public int getRankAsInt() {
        return Integer.parseInt(rank);
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
