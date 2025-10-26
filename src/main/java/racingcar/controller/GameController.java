package racingcar.controller;

import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;

public class GameController {
    private final InputView inputView;

    public GameController() {
        this.inputView = new InputView();
    }

    public void run(){

        // ----- 1번 기능 ------
        // InputView의 readCarNames() 로직을 통해 문자열을 입력받음.
        String carNamesInput = inputView.readCarNames();

        // 입력받은 문자열을 쉼표 기준으로 분리함.
        List<String> carNames = splitCarNames(carNamesInput);
        // ----- -----

        // ----- 2번 기능 -----
        String tryCountInput = inputView.readTryCount();
        System.out.println(tryCountInput);

        // ----- -----
    }

    public List<String> splitCarNames(String input) {
        return Arrays.asList(input.split(","));
    }
}
