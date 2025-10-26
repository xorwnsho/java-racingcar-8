package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameControllerTest {

    private GameController gameController;

    @BeforeEach
    void setUp() {
        gameController = new GameController();
    }

    @Test
    @DisplayName("기능 1: 쉼표로 구분된 문자열을 이름 List로 올바르게 분리한다.")
    void splitCarNames() {
        //given
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
        String input = "pobi";

        //when
        List<String> result = gameController.splitCarNames(input);

        //then
        assertThat(result).containsExactly("pobi");
    }

    @Test
    @DisplayName("3번 기능: 자동차 이름 5자 초과 시 IllegalArgumentException")
    void nameLengthValidation() {
        //given
        String input = "ohjuntaek, woni, jun";

        //when
        List<String> inputList = gameController.splitCarNames(input);

        //then
        assertThatThrownBy(() -> gameController.validateCarNames(inputList))
          .isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }
}