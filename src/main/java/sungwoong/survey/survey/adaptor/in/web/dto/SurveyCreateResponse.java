package sungwoong.survey.survey.adaptor.in.web.dto;


import java.util.List;

public record SurveyCreateResponse(Long id, String title, String description, List<QuestionCreateResponse> questions) {

    public static SurveyCreateResponse of(Long id, String title, String description, List<QuestionCreateResponse> questions) {
        return new SurveyCreateResponse(id, title, description, questions);
    }

}
