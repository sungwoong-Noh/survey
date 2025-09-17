package sungwoong.survey.survey.application.port.required;

import sungwoong.survey.survey.domain.Survey;

public interface SurveyQueryPort {
    Survey findById(Long surveyId);
}
