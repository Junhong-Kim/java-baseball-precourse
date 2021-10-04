package baseball.view;

import baseball.common.Messages;
import baseball.model.Balls;
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
        Balls computerBalls = new Balls(computer.getNumbers());

        InputNumber inputNumber = getInputNumber();
        player.initNumbers(inputNumber);
        Balls playerBalls = new Balls(player.getNumbers());
        BaseballGameResult result = computerBalls.play(playerBalls);
        System.out.println(result.toString());
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
