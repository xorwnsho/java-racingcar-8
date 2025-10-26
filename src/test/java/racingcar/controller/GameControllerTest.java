package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
class GameControllerTest {

    @Test
    @DisplayName("기능 1: 쉼표로 구분된 문자열을 이름 List로 올바르게 분리한다.")
    void splitCarNames() {
        //given
        GameController gameController = new GameController();
        String input = "pobi,woni,jun";

        //when
        List<String> result = gameController.splitCarNames(input);

        //then
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("기능 1: 이름을 하나만 입력해도 List로 올바르게 분리한다.")
    void splitSingleCarName() {
        //given
        GameController gameController = new GameController();
        String input = "pobi";

        //when
        List<String> result = gameController.splitCarNames(input);

        //then
        assertThat(result).containsExactly("pobi");
    }

}