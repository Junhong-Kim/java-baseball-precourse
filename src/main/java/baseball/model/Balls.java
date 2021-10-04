package baseball.model;

import baseball.common.Messages;
import baseball.view.BaseballGameResult;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    public static final int MAX_SIZE = 3;

    private final List<Ball> ballList = new ArrayList<>();

    public List<Ball> getBallList() {
        return ballList;
    }

    public Balls(List<Integer> numbers) {
        if (numbers.size() != MAX_SIZE) {
            throw new IllegalArgumentException(Messages.getBallCount(MAX_SIZE));
        }
        for (int i = 0; i < MAX_SIZE; i++) {
            ballList.add(new Ball(i + 1, numbers.get(i)));
        }
    }

    public BaseballGameResult play(Balls balls) {
        BaseballGameResult baseballGameResult = new BaseballGameResult();
        for (Ball ball : ballList) {
            BallResult result = balls.play(ball);
            baseballGameResult.setResult(result);
        }
        return baseballGameResult;
    }

    private BallResult play(Ball inputBall) {
        return ballList.stream()
                .map(ball -> ball.play(inputBall))
                .filter(result -> result != BallResult.NOTHING)
                .findFirst()
                .orElse(BallResult.NOTHING);
    }
}
