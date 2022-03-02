package org.leanpoker.player;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ChenCalculatorTest {

    @Test
    void firstExample() {
        Card firstCard = new Card();
        firstCard.setRank("5");
        firstCard.setSuit("heart");
        Card secondCard = new Card();
        secondCard.setRank("7");
        secondCard.setSuit("heart");

        int result = ChenCalculator.calculate(List.of(firstCard, secondCard));

        assertThat(result).isEqualTo(6);
    }

    @Test
    void firstExampleSwapped() {
        Card firstCard = new Card();
        firstCard.setRank("5");
        firstCard.setSuit("heart");
        Card secondCard = new Card();
        secondCard.setRank("7");
        secondCard.setSuit("heart");

        int result = ChenCalculator.calculate(List.of(secondCard, firstCard));

        assertThat(result).isEqualTo(6);
    }

    @Test
    void tenAceSuited() {
        int result = ChenCalculator.calculate(List.of(new Card("10", "Heart"), new Card("A", "Heart")));

        assertThat(result).isEqualTo(8);
    }

    @Test
    void examples1() {
        int result = ChenCalculator.calculate(List.of(new Card("A", "Spade"), new Card("K", "Spade")));

        assertThat(result).isEqualTo(12);
    }

    @Test
    void examples2() {
        int result = ChenCalculator.calculate(List.of(new Card("10", "Clubs"), new Card("10", "Diamond")));

        assertThat(result).isEqualTo(10);
    }

    @Test
    void examples3() {
        int result = ChenCalculator.calculate(List.of(new Card("5", "Heart"), new Card("7", "Heart")));

        assertThat(result).isEqualTo(6);
    }

    @Test
    void examples4() {
        int result = ChenCalculator.calculate(List.of(new Card("2", "Clubs"), new Card("7", "Heart")));

        assertThat(result).isEqualTo(-1);
    }

    @Test
    void examples5() {
        int result = ChenCalculator.calculate(List.of(new Card("A", "Clubs"), new Card("A", "Heart")));

        assertThat(result).isEqualTo(20);
    }
}
