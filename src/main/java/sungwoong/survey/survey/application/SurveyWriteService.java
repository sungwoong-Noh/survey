package sungwoong.survey.survey.application;

import sungwoong.survey.survey.adaptor.SurveyCreateRequest;
import sungwoong.survey.survey.domain.Survey;

public interface SurveyWriteService {

    Survey create(SurveyCreateRequest createRequest);
}
