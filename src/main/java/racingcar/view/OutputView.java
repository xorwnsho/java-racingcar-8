package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    // ----- 6번 기능 : 매 라운드별 출력 -----
    private static final String POSITION_BAR = "-";

    public void printExecutionResultHeader() {
        System.out.println("\n실행 결과");
    }

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            String name = car.getName();
            String positionDisplay = convertPositionToBars(car.getPosition());
            System.out.println(name + " : " + positionDisplay);
        }
        System.out.println();
    }

    private String convertPositionToBars(int position) {
        return POSITION_BAR.repeat(position);
    }

    // ----- 7번 기능 : 최종 우승자 출력 -----
    public void printWinners(List<Car> winners){
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
