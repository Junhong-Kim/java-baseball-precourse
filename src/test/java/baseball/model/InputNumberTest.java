package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "1"})
    @DisplayName("인스턴스 생성 성공 테스트")
    void inputNumber_constructor_successTest(String input) {
        // given
        // when
        // then
        assertThat(new InputNumber(input)).isInstanceOf(InputNumber.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "abc", "가나다"})
    @DisplayName("인스턴스 생성 실패 테스트")
    void inputNumber_constructor_failureTest(String input) {
        // given
        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new InputNumber(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789"})
    @DisplayName("isValid true 테스트")
    void isValid_trueTest(String input) {
        // given
        // when
        InputNumber inputNumber = new InputNumber(input);

        // then
        assertThat(inputNumber.isValid()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"99", "1000", "120", "112"})
    @DisplayName("isValid false 테스트")
    void isValid_falseTest(String input) {
        // given
        // when
        InputNumber inputNumber = new InputNumber(input);

        // then
        assertThat(inputNumber.isValid()).isFalse();
    }
}
