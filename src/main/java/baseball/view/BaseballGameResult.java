package baseball.view;

import baseball.model.BallResult;

public class BaseballGameResult {

    private int strike = 0;
    private int ball = 0;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void setResult(BallResult result) {
        if (result == BallResult.STRIKE) strike++;
        if (result == BallResult.BALL) ball++;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (strike > 0) stringBuilder.append(String.format("%d%s ", strike, BallResult.STRIKE.getName()));
        if (ball > 0) stringBuilder.append(String.format("%d%s ", ball, BallResult.BALL.getName()));
        if (strike == 0 && ball == 0) stringBuilder.append(BallResult.NOTHING.getName());

        return stringBuilder.toString().trim();
    }
}
