package sungwoong.survey.survey.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sungwoong.survey.survey.Question;
import sungwoong.survey.survey.QuestionType;
import sungwoong.survey.survey.Survey;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SurveyTest {

    @Test
    @DisplayName("설문조사 등록")
    void create_Survey_Success() {

        Survey survey = Survey.create("좋아하는 색 조사", "좋아하는 색에 대해조사한다.", List.of(Question.create("좋아하는 색은?", null, QuestionType.SHORT_TEXT, true, null)));

        assertThat(survey.getTitle()).isEqualTo("좋아하는 색 조사");
        assertThat(survey.getDescription()).isEqualTo("좋아하는 색에 대해조사한다.");
        assertThat(survey.getQuestions()).hasSize(1);
        assertThat(survey.getCreatedAt()).isNotNull();
    }

    @Test
    @DisplayName("설문조사 등록 실패 - title은 필수로 입력해야 한다.(100글자 이하)")
    void create_SurveyTitle_ThrowsException() {
        assertThatThrownBy(() -> Survey.create("", "좋아하는 색에 대해조사한다.", List.of(Question.create("좋아하는 색은?", null, QuestionType.SHORT_TEXT, true, null))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("설문조사 제목은 1글자 ~ 100글자 이내로 입력해야 합니다");

        assertThatThrownBy(() -> Survey.create(null, "좋아하는 색에 대해조사한다.", List.of(Question.create("좋아하는 색은?", null, QuestionType.SHORT_TEXT, true, null))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("설문조사 제목은 1글자 ~ 100글자 이내로 입력해야 합니다");

        assertThatThrownBy(() -> Survey.create("a".repeat(101), "좋아하는 색에 대해조사한다.", List.of(Question.create("좋아하는 색은?", null, QuestionType.SHORT_TEXT, true, null))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("설문조사 제목은 1글자 ~ 100글자 이내로 입력해야 합니다");
    }


    @Test
    @DisplayName("설문조사 등록 실패 - description은 필수로 입력해야 한다.(700글자 이하)")
    void create_SurveyDescription_ThrowsException() {
        assertThatThrownBy(() -> Survey.create("좋아하는 색 조사", "", List.of(Question.create("좋아하는 색은?", null, QuestionType.SHORT_TEXT, true, null))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("설문조사 설명은 1글자 ~ 700글자 이내로 입력해야 합니다");

        assertThatThrownBy(() -> Survey.create("좋아하는 색 조사", null, List.of(Question.create("좋아하는 색은?", null, QuestionType.SHORT_TEXT, true, null))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("설문조사 설명은 1글자 ~ 700글자 이내로 입력해야 합니다");

        assertThatThrownBy(() -> Survey.create("좋아하는 색 조사", "a".repeat(701), List.of(Question.create("좋아하는 색은?", null, QuestionType.SHORT_TEXT, true, null))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("설문조사 설명은 1글자 ~ 700글자 이내로 입력해야 합니다");
    }


    @Test
    @DisplayName("설문조사 등록실패 - Question 사이즈는 1 ~ 10개로 입력할 수 있다.")
    void create_QuestionSize_ThrowsException() {

        assertThatThrownBy(() -> Survey.create("좋아하는 색 조사", "좋아하는 색에 대해 조사한다.", null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("설문조사 질문은 1개이상 10개 이하여야 합니다.");

        List<Question> questions = IntStream.range(0, 11).mapToObj(i -> Question.create("좋아하는 색은?", "좋아하는 색에 대해조사한다.", QuestionType.SHORT_TEXT, true, null)).toList();

        assertThatThrownBy(() -> Survey.create("좋아하는 색 조사", "좋아하는 색에 대해 조사한다.", questions))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("설문조사 질문은 1개이상 10개 이하여야 합니다.");

    }
}
