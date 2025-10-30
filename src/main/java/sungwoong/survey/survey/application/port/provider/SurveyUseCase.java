package sungwoong.survey.survey.application.port.provider;

import org.springframework.data.domain.Page;
import sungwoong.survey.survey.domain.Survey;

public interface SurveyUseCase {

    Survey create(Survey survey);

    Survey find(Long surveyId);

    Page<Survey> searchList(String keyword, int page, int size);
}
