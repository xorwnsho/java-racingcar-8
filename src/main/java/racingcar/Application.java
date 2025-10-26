package racingcar;

import racingcar.controller.GameController;

public class Application {
    public static void main(String[] args) {

        GameController gameContoller = new GameController();
        gameContoller.run();
    }
}
