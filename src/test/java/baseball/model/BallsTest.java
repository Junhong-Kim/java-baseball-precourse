package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BallsTest {

    private Balls testBalls;

    @BeforeEach
    void setUp() {
        testBalls = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("3STRIKE 0BALL 테스트")
    void play_3strike_1ball_test() {
        // given
        Balls balls = new Balls(Arrays.asList(1, 2, 3));

        // when
        BaseballGameResult result = testBalls.play(balls);

        // then
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isZero();
    }

    @Test
    @DisplayName("1STRIKE 2BALL 테스트")
    void play_1strike_2ball_test() {
        // given
        Balls balls = new Balls(Arrays.asList(1, 3, 2));

        // when
        BaseballGameResult result = testBalls.play(balls);

        // then
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(2);
    }

    @Test
    @DisplayName("0STRIKE 3BALL 테스트")
    void play_0strike_3ball_test() {
        // given
        Balls balls = new Balls(Arrays.asList(3, 1, 2));

        // when
        BaseballGameResult result = testBalls.play(balls);

        // then
        assertThat(result.getStrike()).isZero();
        assertThat(result.getBall()).isEqualTo(3);
    }

    @Test
    @DisplayName("NOTHING 테스트")
    void play_nothing_test() {
        // given
        Balls balls = new Balls(Arrays.asList(4, 5, 6));

        // when
        BaseballGameResult result = testBalls.play(balls);

        // then
        assertThat(result.getStrike()).isZero();
        assertThat(result.getBall()).isZero();
    }
}
