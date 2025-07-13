package sungwoong.survey.survey.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import sungwoong.survey.survey.Choice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ChoiceTest {

    @Test
    @DisplayName("정상적인 선택지 생성")
    void create_ValidInput_Success() {

        Choice choice = Choice.create("빨간색");

        assertThat(choice.getValue()).isEqualTo("빨간색");
    }

    @ParameterizedTest
    @ValueSource(strings= {"", " ", "   "})
    @DisplayName("값이 공백이면 예외 발생")
    void create_BlankValue_ThrowException(String invalidValue) {

        assertThatThrownBy(() -> Choice.create(invalidValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("필수");
    }

    @Test
    @DisplayName("값이 50자 초과하면 예외 발생")
    void create_ValueToLong_ThrowsException() {

        String longValue = "a".repeat(51);

        assertThatThrownBy(() -> Choice.create(longValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("50자");
    }

}