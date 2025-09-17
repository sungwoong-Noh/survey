package sungwoong.survey.survey.application.port.provider;

import sungwoong.survey.survey.domain.Survey;

public interface SurveyReadService {

    Survey find(Long surveyId);

}
