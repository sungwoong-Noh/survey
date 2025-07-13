package sungwoong.survey.survey.port.provider;

import sungwoong.survey.survey.adaptor.web.dto.SurveyCreateRequest;
import sungwoong.survey.survey.Survey;

// Port
public interface SurveyWriteService {
    Survey create(SurveyCreateRequest createRequest);
}
