package sungwoong.survey.survey.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sungwoong.survey.survey.application.port.provider.SurveyUseCase;
import sungwoong.survey.survey.application.port.required.SurveyCommandPort;
import sungwoong.survey.survey.application.port.required.SurveyQueryPort;
import sungwoong.survey.survey.domain.Survey;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SurveyApplicationService implements SurveyUseCase {

    private final SurveyCommandPort surveyCommandPort;
    private final SurveyQueryPort surveyQueryPort;

//    private final ApplicationEventPublisher applicationEventPublisher;

    /**
     * WriteImpl
     * @return
     */
    @Override
    @Transactional
    public Survey create(Survey survey) {
        return surveyCommandPort.save(survey);
    }

    /**
     * ReadImpl
     * @param surveyId
     * @return
     */
    @Override
    public Survey find(Long surveyId) {
        return surveyQueryPort.findById(surveyId);
    }
}
