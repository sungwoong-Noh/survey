package sungwoong.survey.survey.application;

import sungwoong.survey.survey.domain.Survey;
import sungwoong.survey.survey.adaptor.SurveyCreateRequest;

public interface SurveyWriteService {

    Survey create(SurveyCreateRequest createRequest);
}
