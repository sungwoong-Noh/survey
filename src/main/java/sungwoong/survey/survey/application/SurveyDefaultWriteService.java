package sungwoong.survey.survey.application;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sungwoong.survey.survey.SurveyRepository;
import sungwoong.survey.survey.adaptor.SurveyCreateRequest;
import sungwoong.survey.survey.domain.Survey;
import sungwoong.survey.survey.domain.SurveyFactory;

@Service
@RequiredArgsConstructor
public class SurveyDefaultWriteService implements SurveyWriteService {

    private final SurveyFactory surveyFactory;

    private final SurveyRepository surveyRepository;

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    @Transactional
    public Survey create(SurveyCreateRequest createRequest) {

        Survey survey = surveyFactory.create(createRequest);

//        survey.getSurveyCreateEvents().forEach(applicationEventPublisher::publishEvent);
//        survey.getSurveyCreateEvents().clear();

        return surveyRepository.save(survey);
    }
}
