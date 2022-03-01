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
}
