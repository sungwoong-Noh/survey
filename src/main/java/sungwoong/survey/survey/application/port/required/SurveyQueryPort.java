package sungwoong.survey.survey.application.port.required;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sungwoong.survey.survey.domain.Survey;

public interface SurveyQueryPort {

    Survey findById(Long surveyId);

    Page<Survey> searchList(String keyword, Pageable pageable);
}
