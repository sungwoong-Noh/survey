package sungwoong.survey.survey.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sungwoong.survey.survey.Choice;
import sungwoong.survey.survey.Question;
import sungwoong.survey.survey.QuestionType;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class QuestionTest {

    @Test
    @DisplayName("단문 질문 정상 생성")
    void create_ShortTextQuestion_Success() {

        Question question = Question.create("이름을 입력하세요", "필수 항목", QuestionType.SHORT_TEXT, true, null);

        assertThat(question.getQuestionText()).isEqualTo("이름을 입력하세요");
        assertThat(question.getDescription()).isEqualTo("필수 항목");
        assertThat(question.getQuestionType()).isEqualTo(QuestionType.SHORT_TEXT);
        assertThat(question.isRequired()).isTrue();
        assertThat(question.getChoices()).isEmpty();
    }

    @Test
    @DisplayName("질문 제목은 필수이고, 1 ~ 50글자로 입력해야 한다")
    void create_QuestionText_ThrowsException() {

        assertThatThrownBy(() -> Question.create(null, "설명", QuestionType.SHORT_TEXT, true, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("질문 제목은 1글자 ~ 50글자 이내로 입력해야 합니다");

        assertThatThrownBy(() -> Question.create("", "설명", QuestionType.SHORT_TEXT, true, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("질문 제목은 1글자 ~ 50글자 이내로 입력해야 합니다");

    }

    @Test
    @DisplayName("질문 설명은 50글자가 넘으면 안된다.")
    void create_QuestionDescription_ThrowsException() {

        assertThatThrownBy(() -> Question.create("제목", "a".repeat(51), QuestionType.SHORT_TEXT, true, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("질문 설명은 50글자 이내로 입력해야 합니다");
    }

    @Test
    void create_TextQuestion_ThrowsException() {

        assertThatThrownBy(() -> Question.create("제목", "설명", QuestionType.SHORT_TEXT, true, List.of(Choice.create("value"))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("주관식 질문은 선택지를 가질 수 없습니다");

        assertThatThrownBy(() -> Question.create("제목", "설명", QuestionType.LONG_TEXT, true, List.of(Choice.create("value"))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("주관식 질문은 선택지를 가질 수 없습니다");
    }
    

    @Test
    @DisplayName("장문 질문 정상 생성")
    void create_LongTextQuestion_Success() {

        Question question = Question.create("이름을 입력하세요", "필수 항목", QuestionType.LONG_TEXT, true, null);

        assertThat(question.getQuestionText()).isEqualTo("이름을 입력하세요");
        assertThat(question.getDescription()).isEqualTo("필수 항목");
        assertThat(question.getQuestionType()).isEqualTo(QuestionType.LONG_TEXT);
        assertThat(question.isRequired()).isTrue();
        assertThat(question.getChoices()).isEmpty();
    }


    @Test
    @DisplayName("단일 선택 질문 생성 - 성공")
    void create_SingleChoice_Success() {

        Question question = Question.create("좋아하는 색을 골라라", "하나만 골라라", QuestionType.SINGLE_CHOICE, true, List.of(Choice.create("빨간색")));

        assertThat(question.getQuestionText()).isEqualTo("좋아하는 색을 골라라");
        assertThat(question.getQuestionType()).isEqualTo(QuestionType.SINGLE_CHOICE);
        assertThat(question.getChoices()).hasSize(1);
    }

    @Test
    @DisplayName("단일 선택 질문 생성 실패 - 선택지가 등록되지 않음")
    void create_SingleChoice_ThrowsException_choiceEmpty() {
        assertThatThrownBy(() -> Question.create("좋아하는 색을 골라라", "필수 항목", QuestionType.SINGLE_CHOICE, true, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("선택 유형의 질문은 선택지를 추가하여야 합니다");

        assertThatThrownBy(() -> Question.create("좋아하는 색을 골라라", "필수 항목", QuestionType.SINGLE_CHOICE, true, List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("선택 유형의 질문은 선택지를 추가하여야 합니다");
    }

    @Test
    @DisplayName("다중 선택 질문 생성")
    void create__MultiChoice_Success() {
        Question question = Question.create("좋아하는 색을 골라라", "여러개 골라도된다.", QuestionType.MULTI_CHOICE, true, List.of(Choice.create("빨간색"), Choice.create("파란색")));

        assertThat(question.getQuestionText()).isEqualTo("좋아하는 색을 골라라");
        assertThat(question.getDescription()).isEqualTo("여러개 골라도된다.");
        assertThat(question.getQuestionType()).isEqualTo(QuestionType.MULTI_CHOICE);
        assertThat(question.getChoices()).hasSize(2);
    }

    @Test
    @DisplayName("다중 선택 질문 생성 실패 - 선택지가 등록되지 않음")
    void create_MultiChoice_ThrowsException_choiceEmpty() {

        assertThatThrownBy(() -> Question.create("좋아하는 색을 골라라", "여러개 골라도된다.", QuestionType.MULTI_CHOICE, true, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("선택 유형의 질문은 선택지를 추가하여야 합니다");


        assertThatThrownBy(() -> Question.create("좋아하는 색을 골라라", "여러개 골라도된다.", QuestionType.MULTI_CHOICE, true, List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("선택 유형의 질문은 선택지를 추가하여야 합니다");
    }

    @Test
    @DisplayName("선택지 10개 초과하면 예외 발생")
    void create_TooManyChoices_ThrowsException() {

        List<Choice> choices = IntStream.range(0, 11)
                .mapToObj(i -> Choice.create("선택지" + i))
                .toList();

        assertThatThrownBy(() -> Question.create("좋아하는 색을 골라라", "여러개 골라도된다.", QuestionType.MULTI_CHOICE, true, choices))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("선택지는 최대 10개까지 추가할 수 있습니다");

    }

}