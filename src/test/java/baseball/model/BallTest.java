package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BallTest {

    private Ball testBall;

    @BeforeEach
    void setUp() {
         testBall = new Ball(1, 1);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1"}, delimiter = ':')
    @DisplayName("STRIKE 테스트")
    void strike_test(int position, int value) {
        // given
        Ball ball = new Ball(position, value);

        // when
        BallResult ballResult = testBall.play(ball);

        // then
        Assertions.assertThat(ballResult).isEqualTo(BallResult.STRIKE);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:1", "3:1"}, delimiter = ':')
    @DisplayName("BALL equal 테스트")
    void ball_equalTest(int position, int value) {
        // given
        Ball ball = new Ball(position, value);

        // when
        BallResult ballResult = testBall.play(ball);

        // then
        Assertions.assertThat(ballResult).isEqualTo(BallResult.BALL);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1"}, delimiter = ':')
    @DisplayName("BALL notEqual 테스트")
    void ball_notEqualTest(int position, int value) {
        // given
        Ball ball = new Ball(position, value);

        // when
        BallResult ballResult = testBall.play(ball);

        // then
        Assertions.assertThat(ballResult).isNotEqualTo(BallResult.BALL);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2", "1:3", "2:4", "2:5", "2:6", "3:7", "3:8", "3:9"}, delimiter = ':')
    @DisplayName("NOTHING 테스트")
    void nothing_test(int position, int value) {
        // given
        Ball ball = new Ball(position, value);

        // when
        BallResult ballResult = testBall.play(ball);

        // then
        Assertions.assertThat(ballResult).isEqualTo(BallResult.NOTHING);
    }
}
