package sungwoong.survey.survey.adaptor.in.web.dto;

import java.util.List;

public record QuestionCreateResponse (Long id, String questionText, String description, String questionType, boolean required, List<ChoiceCreateResponse> choices) {

    public static QuestionCreateResponse of (Long id, String questionText, String description, String questionType, boolean required, List<ChoiceCreateResponse> choices) {
        return new QuestionCreateResponse(id, questionText, description, questionType, required, choices);
    }
}
