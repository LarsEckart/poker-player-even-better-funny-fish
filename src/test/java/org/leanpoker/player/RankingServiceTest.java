package org.leanpoker.player;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RankingServiceTest {

    @Test
    void name() {
        RankingService rankingService = new RankingService();
        int result = rankingService.call(List.of(
                new Card("5", "diamonds"),
                new Card("6", "diamonds"),
                new Card("7", "diamonds"),
                new Card("8", "diamonds"),
                new Card("9", "diamonds"),
                new Card("7", "spades")));

        assertThat(result).isEqualTo(8);
    }
}
