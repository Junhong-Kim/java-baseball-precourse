package baseball.view;

import baseball.common.Messages;
import baseball.model.Balls;
import baseball.model.Computer;
import baseball.model.GameOption;
import baseball.model.InputNumber;
import baseball.model.Player;
import nextstep.utils.Console;

public class BaseballGame implements Game {

    private final Computer computer = new Computer();
    private final Player player = new Player();

    @Override
    public void start() {
        Balls computerBalls = getComputerBalls();
        BaseballGameResult result;
        do {
            Balls playerBalls = getPlayerBalls();
            result = computerBalls.play(playerBalls);
            System.out.println(result.toString());
        } while (result.getStrike() != Balls.MAX_SIZE);
        finish();
    }

    @Override
    public void finish() {
        System.out.println(Messages.CORRECT_ANSWER);
        System.out.println(Messages.SELECT_GAME_OPTION);

        GameOption gameOption = GameOption.of(Console.readLine());
        if (gameOption.isRestart()) start();
    }

    private Balls getComputerBalls() {
        computer.initNumbers();
        return new Balls(computer.getNumbers());
    }

    private Balls getPlayerBalls() {
        InputNumber inputNumber = getInputNumber();
        player.initNumbers(inputNumber);
        return new Balls(player.getNumbers());
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
