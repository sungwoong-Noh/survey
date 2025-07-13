package sungwoong.survey.survey.application.fixture;

import sungwoong.survey.survey.QuestionType;
import sungwoong.survey.survey.adaptor.web.dto.QuestionCreateRequest;
import sungwoong.survey.survey.adaptor.web.dto.SurveyCreateRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FixtureCreateRequest {

    public static SurveyCreateRequest surveyCreateRequest_questionOver() {
        List<QuestionCreateRequest> questionCreateRequests = new ArrayList<>();
        IntStream.range(0, 11).forEach(i -> {
            questionCreateRequests.add(new QuestionCreateRequest("qq", "qq", QuestionType.SHORT_TEXT.name(), false, null));
        });

        return new SurveyCreateRequest("a".repeat(101), "a".repeat(701), null);

    }
}
