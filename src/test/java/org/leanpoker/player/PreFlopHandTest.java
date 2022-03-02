package org.leanpoker.player;

import java.util.List;

import org.junit.jupiter.api.Test;

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
}
