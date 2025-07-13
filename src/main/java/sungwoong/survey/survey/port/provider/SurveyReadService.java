package sungwoong.survey.survey.port.provider;

import sungwoong.survey.survey.Survey;

public interface SurveyReadService {

    Survey find(Long surveyId);

}
