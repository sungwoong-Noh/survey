package sungwoong.survey.survey.adaptor.in.web.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import sungwoong.survey.survey.domain.QuestionType;

import java.util.List;

public record QuestionCreateRequest(
        @NotBlank(message = "질문 내용은 필수입니다.") @Size(max = 100, message = "질문 내용은 1글자 이상 100글자 이하여야 합니다.") String questionText,
        @NotBlank @Pattern(regexp = "SINGLE_CHOICE|MULTI_CHOICE|SHORT_TEXT|LONG_TEXT", message = "유효하지 않은 질문 유형입니다.") String questionType,
        @NotNull(message = "질문 필수여부를 선택해주세요.") Boolean isRequired,
        @Size(max = 50, message = "질문 설명은 50글자 이내여야 합니다.") String description,
        @Valid List<ChoiceCreateRequest> choiceCreateRequestList
) {
    public QuestionType getQuestionTypeEnum() {
        try {
            return QuestionType.valueOf(questionType);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("유효하지 않은 질문 유형입니다: " + this.questionType);
        }
    }

}
