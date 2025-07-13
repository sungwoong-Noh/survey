package sungwoong.survey.survey.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sungwoong.survey.survey.port.provider.SurveyReadService;
import sungwoong.survey.survey.port.required.SurveyJpaRepository;
import sungwoong.survey.survey.adaptor.web.dto.SurveyCreateRequest;
import sungwoong.survey.survey.port.provider.SurveyWriteService;
import sungwoong.survey.survey.Survey;
import sungwoong.survey.survey.SurveyFactory;

@Service
@RequiredArgsConstructor
public class SurveyDefaultService implements SurveyWriteService, SurveyReadService {

    private final SurveyFactory surveyFactory;

    private final SurveyJpaRepository surveyRepository;

//    private final ApplicationEventPublisher applicationEventPublisher;
    /**
     * WriteImpl
     * @param createRequest
     * @return
     */
    @Override
    @Transactional
    public Survey create(SurveyCreateRequest createRequest) {

        Survey survey = surveyFactory.create(createRequest);

//        survey.getSurveyCreateEvents().forEach(applicationEventPublisher::publishEvent);
//        survey.getSurveyCreateEvents().clear();

        return surveyRepository.save(survey);
    }

    /**
     * ReadImpl
     * @param surveyId
     * @return
     */
    @Override
    public Survey find(Long surveyId) {
        return surveyRepository.findById(surveyId).orElseThrow(() -> new IllegalArgumentException("Survey not found"));
    }
}
