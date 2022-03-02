package org.leanpoker.player;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class PreFlopHandTest {

    @Test
    void aceKing() {
        PreFlopHand preFlopHand = new PreFlopHand(List.of(new Card("A", "Heart"), new Card("K", "Heart")));

        double result = preFlopHand.scoreHighestCard();

        assertThat(result).isEqualTo(10);
    }

    @Test
    void queenKing() {
        PreFlopHand preFlopHand = new PreFlopHand(List.of(new Card("Q", "Heart"), new Card("K", "Heart")));

        double result = preFlopHand.scoreHighestCard();

        assertThat(result).isEqualTo(8);
    }

    @Test
    void kingKing() {
        PreFlopHand preFlopHand = new PreFlopHand(List.of(new Card("K", "Heart"), new Card("K", "Heart")));

        double result = preFlopHand.scoreHighestCard();

        assertThat(result).isEqualTo(8);
    }

    @Test
    void queenJack() {
        PreFlopHand preFlopHand = new PreFlopHand(List.of(new Card("J", "Heart"), new Card("Q", "Heart")));

        double result = preFlopHand.scoreHighestCard();

        assertThat(result).isEqualTo(7);
    }

    @Test
    void tenJack() {
        PreFlopHand preFlopHand = new PreFlopHand(List.of(new Card("J", "Heart"), new Card("10", "Heart")));

        double result = preFlopHand.scoreHighestCard();

        assertThat(result).isEqualTo(6);
    }

    @Test
    void tenNine() {
        PreFlopHand preFlopHand = new PreFlopHand(List.of(new Card("9", "Heart"), new Card("10", "Heart")));

        double result = preFlopHand.scoreHighestCard();

        assertThat(result).isEqualTo(5);
    }

    @Test
    void eightNine() {
        PreFlopHand preFlopHand = new PreFlopHand(List.of(new Card("9", "Heart"), new Card("8", "Heart")));

        double result = preFlopHand.scoreHighestCard();

        assertThat(result).isEqualTo(4.5);
    }

    @Test
    void isPair() {
        PreFlopHand preFlopHand = new PreFlopHand(List.of(new Card("A", "Heart"), new Card("A", "Clubs")));

        boolean result = preFlopHand.isPair();

        assertThat(result).isTrue();
    }

    @Test
    void isNotPair() {
        PreFlopHand preFlopHand = new PreFlopHand(List.of(new Card("A", "Heart"), new Card("J", "Clubs")));

        boolean result = preFlopHand.isPair();

        assertThat(result).isFalse();
    }

    @Test
    void isSuited() {
        PreFlopHand preFlopHand = new PreFlopHand(List.of(new Card("A", "Heart"), new Card("Q", "Heart")));

        boolean result = preFlopHand.isSuited();

        assertThat(result).isTrue();
    }

    @Test
    void isNotSuited() {
        PreFlopHand preFlopHand = new PreFlopHand(List.of(new Card("A", "Heart"), new Card("J", "Clubs")));

        boolean result = preFlopHand.isSuited();

        assertThat(result).isFalse();
    }

    @Test
    void noGap() {
        PreFlopHand preFlopHand = new PreFlopHand(List.of(new Card("5", "Heart"), new Card("6", "Clubs")));

        int result = preFlopHand.gap();

        assertThat(result).isEqualTo(0);
    }

    @Test
    void gapOf1() {
        PreFlopHand preFlopHand = new PreFlopHand(List.of(new Card("4", "Heart"), new Card("6", "Clubs")));

        int result = preFlopHand.gap();

        assertThat(result).isEqualTo(1);
    }

    @Test
    void gapOf1Value() {
        PreFlopHand preFlopHand = new PreFlopHand(List.of(new Card("4", "Heart"), new Card("6", "Clubs")));

        int result = preFlopHand.gapValue();

        assertThat(result).isEqualTo(-1);
    }

    @Test
    void gapOf2() {
        PreFlopHand preFlopHand = new PreFlopHand(List.of(new Card("3", "Heart"), new Card("6", "Clubs")));

        int result = preFlopHand.gap();

        assertThat(result).isEqualTo(2);
    }

    @Test
    void gapOf2Value() {
        PreFlopHand preFlopHand = new PreFlopHand(List.of(new Card("3", "Heart"), new Card("6", "Clubs")));

        int result = preFlopHand.gapValue();

        assertThat(result).isEqualTo(-2);
    }

    @Test
    void gapOf3Value() {
        PreFlopHand preFlopHand = new PreFlopHand(List.of(new Card("3", "Heart"), new Card("7", "Clubs")));

        int result = preFlopHand.gapValue();

        assertThat(result).isEqualTo(-4);
    }

    @Test
    void gapOf4Value() {
        PreFlopHand preFlopHand = new PreFlopHand(List.of(new Card("3", "Heart"), new Card("8", "Clubs")));

        int result = preFlopHand.gapValue();

        assertThat(result).isEqualTo(-5);
    }

    @Test
    void gapOfManyValue() {
        PreFlopHand preFlopHand = new PreFlopHand(List.of(new Card("2", "Heart"), new Card("A", "Clubs")));

        int result = preFlopHand.gapValue();

        assertThat(result).isEqualTo(-5);
    }

    @Test
    void bonusPoint() {
        PreFlopHand preFlopHand = new PreFlopHand(List.of(new Card("5", "Heart"), new Card("7", "Clubs")));

        int result = preFlopHand.bonusPoint();

        assertThat(result).isEqualTo(1);
    }

    @Test
    void bonusPoint1() {
        PreFlopHand preFlopHand = new PreFlopHand(List.of(new Card("J", "Heart"), new Card("10", "Clubs")));

        int result = preFlopHand.bonusPoint();

        assertThat(result).isEqualTo(1);
    }

    @Test
    void bonusPointWhenHigherThanQueen() {
        PreFlopHand preFlopHand = new PreFlopHand(List.of(new Card("Q", "Heart"), new Card("A", "Clubs")));

        int result = preFlopHand.bonusPoint();

        assertThat(result).isEqualTo(0);
    }

    @Test
    void noBonusPointWhenGapLargerThan1() {
        PreFlopHand preFlopHand = new PreFlopHand(List.of(new Card("2", "Heart"), new Card("5", "Clubs")));

        int result = preFlopHand.bonusPoint();

        assertThat(result).isEqualTo(0);
    }

    @Test
    void bonusPointWhenHigherThanQueen2() {
        PreFlopHand preFlopHand = new PreFlopHand(List.of(new Card("Q", "Heart"), new Card("10", "Clubs")));

        int result = preFlopHand.bonusPoint();

        assertThat(result).isEqualTo(0);
    }
}
