package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class BallResults {

    private final List<BallResult> ballResultList = new ArrayList<>();

    public void addResult(BallResult ballResult) {
        ballResultList.add(ballResult);
    }

    public BallResult getBallResult() {
        if (ballResultList.contains(BallResult.STRIKE)) return BallResult.STRIKE;
        if (ballResultList.contains(BallResult.BALL)) return BallResult.BALL;

        return BallResult.NOTHING;
    }
}
