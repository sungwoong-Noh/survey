package sungwoong.survey.survey.application.port.provider;

import sungwoong.survey.survey.domain.Survey;

public interface SurveyUseCase {

    Survey create(Survey survey);

    Survey find(Long surveyId);
}
