package org.leanpoker.player;

import java.util.List;

public class RankingDto {

    private List<Card> cards;

    public RankingDto() {
    }

    public RankingDto(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
