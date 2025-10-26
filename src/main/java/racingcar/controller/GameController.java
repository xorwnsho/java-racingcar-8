package racingcar.controller;

import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;

public class GameController {
    private final InputView inputView;
    private static final int MAX_NAME_LENGTH = 5;

    public GameController() {
        this.inputView = new InputView();
    }

    public void run() {

        // ----- 1번 기능 ------
        // InputView의 readCarNames() 로직을 통해 문자열을 입력받음.
        String carNamesInput = inputView.readCarNames();

        // 입력받은 문자열을 쉼표 기준으로 분리함.
        List<String> carNames = splitCarNames(carNamesInput);

        // ----- 3번 기능 -----
        // 이름이 5글자 이상이면 IllegalArgumentException을 터트림.
        validateCarNames(carNames);

        // ----- 2번 기능 -----
        // 시도할 횟수 입력받기
        String tryCountInput = inputView.readTryCount();

        // ----- 4번 기능 -----
        // 시도 횟수가 숫자가 아닐 시 IllegalArgumentException
        int realCount = validateTryCountInput(tryCountInput);
    }

    public List<String> splitCarNames(String input) {
        return Arrays.asList(input.split(","));
    }

    // 3번 기능
    public void validateCarNames(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.trim().length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public int validateTryCountInput(String tryCountInput) {
        int count;
        try{
            count = Integer.parseInt(tryCountInput);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
        return count;
    }

}
