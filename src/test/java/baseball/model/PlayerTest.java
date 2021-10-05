package baseball.model;

import baseball.constant.Messages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789"})
    @DisplayName("numbers 초기화 성공 테스트")
    void initNumbers_successTest(String input) {
        // given
        InputNumber inputNumber = new InputNumber(input);

        // when
        player.initNumbers(inputNumber);

        // then
        assertThat(player.getNumbers().size()).isEqualTo(input.length());
        for (Integer number : player.getNumbers()) {
            assertThat(input).contains(number.toString());
        }
    }

    @Test
    @DisplayName("numbers null 초기화 테스트")
    void initNumbers_nullTest() {
        // given
        // when
        // then
        assertThatNullPointerException()
                .isThrownBy(() -> player.initNumbers(null))
                .withMessage(Messages.INPUT_NUMBER_CAN_NOT_BE_NULL);
    }
}
