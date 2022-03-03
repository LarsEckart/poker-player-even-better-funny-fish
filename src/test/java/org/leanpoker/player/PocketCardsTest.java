package org.leanpoker.player;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// todo: rename pocket cards
class PocketCardsTest {

    @Test
    void aceKing() {
        PocketCards pocketCards = new PocketCards(List.of(new Card("A", "Heart"), new Card("K", "Heart")));

        double result = pocketCards.scoreHighestCard();

        assertThat(result).isEqualTo(10);
    }

    @Test
    void queenKing() {
        PocketCards pocketCards = new PocketCards(List.of(new Card("Q", "Heart"), new Card("K", "Heart")));

        double result = pocketCards.scoreHighestCard();

        assertThat(result).isEqualTo(8);
    }

    @Test
    void kingKing() {
        PocketCards pocketCards = new PocketCards(List.of(new Card("K", "Heart"), new Card("K", "Heart")));

        double result = pocketCards.scoreHighestCard();

        assertThat(result).isEqualTo(8);
    }

    @Test
    void queenJack() {
        PocketCards pocketCards = new PocketCards(List.of(new Card("J", "Heart"), new Card("Q", "Heart")));

        double result = pocketCards.scoreHighestCard();

        assertThat(result).isEqualTo(7);
    }

    @Test
    void tenJack() {
        PocketCards pocketCards = new PocketCards(List.of(new Card("J", "Heart"), new Card("10", "Heart")));

        double result = pocketCards.scoreHighestCard();

        assertThat(result).isEqualTo(6);
    }

    @Test
    void tenNine() {
        PocketCards pocketCards = new PocketCards(List.of(new Card("9", "Heart"), new Card("10", "Heart")));

        double result = pocketCards.scoreHighestCard();

        assertThat(result).isEqualTo(5);
    }

    @Test
    void eightNine() {
        PocketCards pocketCards = new PocketCards(List.of(new Card("9", "Heart"), new Card("8", "Heart")));

        double result = pocketCards.scoreHighestCard();

        assertThat(result).isEqualTo(4.5);
    }

    @Test
    void isPair() {
        PocketCards pocketCards = new PocketCards(List.of(new Card("A", "Heart"), new Card("A", "Clubs")));

        boolean result = pocketCards.isPair();

        assertThat(result).isTrue();
    }

    @Test
    void isNotPair() {
        PocketCards pocketCards = new PocketCards(List.of(new Card("A", "Heart"), new Card("J", "Clubs")));

        boolean result = pocketCards.isPair();

        assertThat(result).isFalse();
    }

    @Test
    void isSuited() {
        PocketCards pocketCards = new PocketCards(List.of(new Card("A", "Heart"), new Card("Q", "Heart")));

        boolean result = pocketCards.isSuited();

        assertThat(result).isTrue();
    }

    @Test
    void isNotSuited() {
        PocketCards pocketCards = new PocketCards(List.of(new Card("A", "Heart"), new Card("J", "Clubs")));

        boolean result = pocketCards.isSuited();

        assertThat(result).isFalse();
    }

    @Test
    void noGap() {
        PocketCards pocketCards = new PocketCards(List.of(new Card("5", "Heart"), new Card("6", "Clubs")));

        int result = pocketCards.gap();

        assertThat(result).isEqualTo(0);
    }

    @Test
    void gapOf1() {
        PocketCards pocketCards = new PocketCards(List.of(new Card("4", "Heart"), new Card("6", "Clubs")));

        int result = pocketCards.gap();

        assertThat(result).isEqualTo(1);
    }

    @Test
    void gapOf1Value() {
        PocketCards pocketCards = new PocketCards(List.of(new Card("4", "Heart"), new Card("6", "Clubs")));

        int result = pocketCards.gapValue();

        assertThat(result).isEqualTo(-1);
    }

    @Test
    void gapOf2() {
        PocketCards pocketCards = new PocketCards(List.of(new Card("3", "Heart"), new Card("6", "Clubs")));

        int result = pocketCards.gap();

        assertThat(result).isEqualTo(2);
    }

    @Test
    void gapOf2Value() {
        PocketCards pocketCards = new PocketCards(List.of(new Card("3", "Heart"), new Card("6", "Clubs")));

        int result = pocketCards.gapValue();

        assertThat(result).isEqualTo(-2);
    }

    @Test
    void gapOf3Value() {
        PocketCards pocketCards = new PocketCards(List.of(new Card("3", "Heart"), new Card("7", "Clubs")));

        int result = pocketCards.gapValue();

        assertThat(result).isEqualTo(-4);
    }

    @Test
    void gapOf4Value() {
        PocketCards pocketCards = new PocketCards(List.of(new Card("3", "Heart"), new Card("8", "Clubs")));

        int result = pocketCards.gapValue();

        assertThat(result).isEqualTo(-5);
    }

    @Test
    void gapOfManyValue() {
        PocketCards pocketCards = new PocketCards(List.of(new Card("2", "Heart"), new Card("A", "Clubs")));

        int result = pocketCards.gapValue();

        assertThat(result).isEqualTo(-5);
    }

    @Test
    void bonusPoint() {
        PocketCards pocketCards = new PocketCards(List.of(new Card("5", "Heart"), new Card("7", "Clubs")));

        int result = pocketCards.bonusPoint();

        assertThat(result).isEqualTo(1);
    }

    @Test
    void bonusPoint1() {
        PocketCards pocketCards = new PocketCards(List.of(new Card("J", "Heart"), new Card("10", "Clubs")));

        int result = pocketCards.bonusPoint();

        assertThat(result).isEqualTo(1);
    }

    @Test
    void bonusPointWhenHigherThanQueen() {
        PocketCards pocketCards = new PocketCards(List.of(new Card("Q", "Heart"), new Card("A", "Clubs")));

        int result = pocketCards.bonusPoint();

        assertThat(result).isEqualTo(0);
    }

    @Test
    void noBonusPointWhenGapLargerThan1() {
        PocketCards pocketCards = new PocketCards(List.of(new Card("2", "Heart"), new Card("5", "Clubs")));

        int result = pocketCards.bonusPoint();

        assertThat(result).isEqualTo(0);
    }

    @Test
    void bonusPointWhenHigherThanQueen2() {
        PocketCards pocketCards = new PocketCards(List.of(new Card("Q", "Heart"), new Card("10", "Clubs")));

        int result = pocketCards.bonusPoint();

        assertThat(result).isEqualTo(0);
    }
}
