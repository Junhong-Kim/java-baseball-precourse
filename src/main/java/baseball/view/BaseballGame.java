package baseball.view;

import baseball.model.Computer;

public class BaseballGame implements Game {

    @Override
    public void start() {
        Computer computer = new Computer();
        computer.initNumbers();
    }
}
