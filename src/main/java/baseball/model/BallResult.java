package baseball.model;

public enum BallResult {

    STRIKE("스트라이크", "STRIKE")
    , BALL("볼", "BALL")
    , NOTHING("낫싱", "NOTHING");

    private final String name;
    private final String value;

    BallResult(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
