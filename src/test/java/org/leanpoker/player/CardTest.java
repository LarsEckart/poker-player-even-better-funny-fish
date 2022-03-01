package org.leanpoker.player;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CardTest {

    @Test
    void king() {
        Card king = new Card();
        king.setRank("K");
        assertThat(king.getRankAsInt()).isEqualTo(14);
    }

    @Test
    void queen() {
        Card king = new Card();
        king.setRank("Q");
        assertThat(king.getRankAsInt()).isEqualTo(13);
    }

    @Test
    void jack() {
        Card king = new Card();
        king.setRank("J");
        assertThat(king.getRankAsInt()).isEqualTo(12);
    }

    @Test
    void ace() {
        Card king = new Card();
        king.setRank("J");
        assertThat(king.getRankAsInt()).isEqualTo(11);
    }
}
