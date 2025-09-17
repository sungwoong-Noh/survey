package sungwoong.survey.survey.application.port.provider;

import sungwoong.survey.survey.adaptor.in.web.dto.SurveyCreateRequest;
import sungwoong.survey.survey.domain.Survey;

// Port
public interface SurveyWriteService {
    Survey create(Survey survey);
}
