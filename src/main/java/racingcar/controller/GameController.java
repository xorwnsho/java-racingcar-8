package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    private final InputView inputView;

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
        List<Car> cars = createCars(carNames);

        // ----- 2번 기능 -----
        // 시도할 횟수 입력받기
        String tryCountInput = inputView.readTryCount();

        // ----- 4번 기능 -----
        // 시도 횟수가 숫자가 아닐 시 IllegalArgumentException
        int realCount = validateTryCountInput(tryCountInput);

        // ----- 5번 기능 -----
        RacingGame racingGame = new RacingGame(cars);

        System.out.println("\n실행 결과");
        for (int i = 0; i < realCount; i++) {
            racingGame.playRound();
        }
    }

    public List<String> splitCarNames(String input) {
        return Arrays.asList(input.split(","));
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

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(name -> new Car(name.trim()))
                .collect(Collectors.toList());
    }

}
