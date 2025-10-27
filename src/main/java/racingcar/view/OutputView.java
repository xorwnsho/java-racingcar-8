package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

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
}
