package sungwoong.survey.survey.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sungwoong.survey.survey.adaptor.out.SurveyJpaRepository;
import sungwoong.survey.survey.application.port.provider.SurveyReadService;
import sungwoong.survey.survey.application.port.provider.SurveyWriteService;
import sungwoong.survey.survey.domain.Survey;

@Service
@RequiredArgsConstructor
public class SurveyDefaultService implements SurveyWriteService, SurveyReadService {

    private final SurveyJpaRepository surveyRepository;

//    private final ApplicationEventPublisher applicationEventPublisher;

    /**
     * WriteImpl
     * @return
     */
    @Override
    @Transactional
    public Survey create(Survey survey) {

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
