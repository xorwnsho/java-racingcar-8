package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {
    private Car pobi;
    private Car woni;
    private Car jun;
    private RacingGame racingGame;

    @BeforeEach
    void setUp(){
        pobi = new Car("pobi");
        woni = new Car("woni");
        jun = new Car("jun");
    }

    @Test
    @DisplayName("기능 7 : 한 명이 단독 우승하는 경우")
    void getWinners_SingleWinners(){
        //given
        racingGame = new RacingGame(Arrays.asList(pobi, woni));

        //when
        assertRandomNumberInRangeTest(
                () -> racingGame.playRound(),
                4, 3
        );

        //then
        List<Car> winners = racingGame.getWinners();
        assertEquals(1, winners.size());
        assertEquals(pobi, winners.get(0));
    }

    @Test
    @DisplayName("기능 7 : 여러 명이 공동 우승하는 경우")
    void getWinners_MultipleWinners(){
        //given
        racingGame = new RacingGame(Arrays.asList(pobi, woni, jun));

        //when
        assertRandomNumberInRangeTest(racingGame::playRound, 5,6,5);
        assertRandomNumberInRangeTest(racingGame::playRound, 6,8,1);

        //then
        List<Car> winners = racingGame.getWinners();
        assertThat(winners).containsExactly(pobi,woni);
    }

    @Test
    @DisplayName("기능 7: 아무도 전진하지 못했을 경우(모두 0점으로 공동 우승)")
    void getWinners_NoMoves(){
        //given
        racingGame = new RacingGame(Arrays.asList(pobi,woni,jun));

        //when
        assertRandomNumberInRangeTest(racingGame::playRound, 0, 3,2);

        //then
        List<Car> winners = racingGame.getWinners();
        assertThat(winners).containsExactly(pobi,woni,jun);
    }

}