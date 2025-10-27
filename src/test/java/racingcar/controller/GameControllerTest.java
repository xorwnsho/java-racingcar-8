package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

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
    @DisplayName("기능 3 : 자동차 이름 5자 초과 시 IllegalArgumentException")
    void createCarW_WithLongName(){
        //given
        String longName = "ohjuntaek";

        //when&then
        assertThatThrownBy(()-> new Car(longName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
    }

    @DisplayName("기능 3 : 비어있거나 공백인 이름으로 Car를 생성하면 IllegalArgumentException")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void createCar_WithEmptyOrBlankName(String emptyName){
        // when&then
        assertThatThrownBy(() -> new Car(emptyName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
    }

    @DisplayName("기능 3: 유효한 이름으로 Car를 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni", "jun"})
    void createCar_withValidName(String validName){
        //when&then
        assertThatCode(()-> new Car(validName)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("기능 4 : 시도 횟수가 숫자가 아닐 시 IllegalArgumentException")
    void tryCountInputIntValidation(){
        //given
        String input = "test";

        //then
        assertThatThrownBy(() -> gameController.validateTryCountInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 숫자여야 합니다.");
    }
}