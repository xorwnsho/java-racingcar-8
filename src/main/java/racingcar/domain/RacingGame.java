package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RacingGame {

    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void playRound(){
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

}
