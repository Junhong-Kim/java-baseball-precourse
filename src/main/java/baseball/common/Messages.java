package baseball.common;

public class Messages {

    private Messages() {
    }

    public static final String READ_INPUT = "숫자를 입력해주세요 : ";
    public static final String INPUT_NUMBER_CAN_NOT_BE_NULL = "InputNumber는 null일 수 없습니다.";
    public static final String CORRECT_ANSWER = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";

    // ERROR
    public static final String INVALID_INPUT = "[ERROR] 유효하지 않은 입력 값 입니다.";
    public static final String INPUT_IS_NOT_NUMBER = "[ERROR] 입력 값이 숫자가 아닙니다.";

    public static String getBallCount(int ballListSize) {
        return String.format("Ball 개수는 %d개여야합니다.", ballListSize);
    }
}
