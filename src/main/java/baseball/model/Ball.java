package baseball.model;

import java.util.Objects;

public class Ball {

    private final int position;
    private final int value;

    public Ball(int position, int value) {
        this.position = position;
        this.value = value;
    }

    public BallResult play(Ball ball) {
        if (this.equals(ball)) return BallResult.STRIKE;
        if (this.value == ball.value) return BallResult.BALL;

        return BallResult.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && value == ball.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, value);
    }
}
