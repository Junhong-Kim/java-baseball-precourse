package baseball.view;

import baseball.common.Messages;
import baseball.model.Computer;
import baseball.model.InputNumber;
import baseball.model.Player;
import nextstep.utils.Console;

public class BaseballGame implements Game {

    private final Computer computer = new Computer();
    private final Player player = new Player();

    @Override
    public void start() {
        computer.initNumbers();

        InputNumber inputNumber = getInputNumber();
        player.initNumbers(inputNumber);
    }

    private InputNumber getInputNumber() {
        InputNumber inputNumber = readInputNumber();
        if (!inputNumber.isValid()) {
            System.out.println(Messages.INVALID_INPUT);
            return getInputNumber();
        }
        return inputNumber;
    }

    private InputNumber readInputNumber() {
        try {
            System.out.print(Messages.READ_INPUT);
            return new InputNumber(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(Messages.INPUT_IS_NOT_NUMBER);
            return getInputNumber();
        }
    }
}
