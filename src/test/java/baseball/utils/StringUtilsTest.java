package baseball.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "1"})
    @DisplayName("숫자 문자열 true 테스트")
    void isNumber_trueTest(String input) {
        // given
        // when
        // then
        assertThat(StringUtils.isNumber(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "abc", "가나다"})
    @DisplayName("숫자가 아닌 문자열 false 테스트")
    void isNumber_falseTest(String input) {
        // given
        // when
        // then
        assertThat(StringUtils.isNumber(input)).isFalse();
    }

    @Test
    @DisplayName("null 테스트")
    void isNumber_nullTest() {
        // given
        // when
        // then
        assertThat(StringUtils.isNumber(null)).isFalse();
    }
}
