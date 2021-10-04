package baseball.model;

import baseball.common.Messages;

public enum GameOption {

    RESTART("게임 새로 시작", "1")
    , EXIT("게임 종료", "2");

    private final String name;
    private final String value;

    GameOption(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public static GameOption of(String option) {
        if (option.equals(RESTART.getValue())) return RESTART;
        if (option.equals(EXIT.getValue())) return EXIT;

        throw new IllegalArgumentException(Messages.INVALID_GAME_OPTION);
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public boolean isRestart() {
        return this.value.equals(RESTART.getValue());
    }

    public boolean isExit() {
        return this.value.equals(EXIT.getValue());
    }
}
