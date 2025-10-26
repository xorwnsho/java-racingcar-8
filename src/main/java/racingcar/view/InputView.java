package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    // 일단 자동차 이름만 입력받는다.
    public String readCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    // 시도할 횟수를 입력 받는다.
    public String readTryCount(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }
}
