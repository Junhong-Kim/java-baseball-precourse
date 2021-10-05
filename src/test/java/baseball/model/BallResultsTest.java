package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallResultsTest {

    private BallResults ballResults;

    @BeforeEach
    void setUp() {
        ballResults = new BallResults();
    }

    @Test
    @DisplayName("getBallResult STRIKE 테스트")
    void getBallResult_strikeTest() {
        // given
        ballResults.addResult(BallResult.NOTHING);
        ballResults.addResult(BallResult.STRIKE);
        ballResults.addResult(BallResult.NOTHING);

        // when
        BallResult ballResult = ballResults.getBallResult();

        // then
        assertThat(ballResult).isEqualTo(BallResult.STRIKE);
    }

    @Test
    @DisplayName("getBallResult BALL 테스트")
    void getBallResult_ballTest() {
        // given
        ballResults.addResult(BallResult.NOTHING);
        ballResults.addResult(BallResult.BALL);
        ballResults.addResult(BallResult.NOTHING);

        // when
        BallResult ballResult = ballResults.getBallResult();

        // then
        assertThat(ballResult).isEqualTo(BallResult.BALL);
    }

    @Test
    @DisplayName("getBallResult NOTHING 테스트")
    void getBallResult_nothingTest() {
        // given
        ballResults.addResult(BallResult.NOTHING);
        ballResults.addResult(BallResult.NOTHING);
        ballResults.addResult(BallResult.NOTHING);

        // when
        BallResult ballResult = ballResults.getBallResult();

        // then
        assertThat(ballResult).isEqualTo(BallResult.NOTHING);
    }
}
