package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    // ----- 6번 기능 : 매 라운드별 결과 출력 -----
    public void playRound() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    // ----- 7번 기능 : 우승자 판별 로직 -----
    public List<Car> getWinners() {
        int maxPosition = findMaxPosition();
        List<Car> winners = new ArrayList<>();

        findAndAddWinners(winners, maxPosition);
        return winners;


    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    private void findAndAddWinners(List<Car> winners, int maxPosition) {
        for (Car car : cars) {
            if(car.getPosition() == maxPosition)
                winners.add(car);
        }
    }
}
