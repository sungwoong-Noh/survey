package sungwoong.survey.survey.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sungwoong.survey.survey.*;
import sungwoong.survey.survey.adaptor.SurveyCreateRequest;
import sungwoong.survey.survey.domain.Survey;
import sungwoong.survey.survey.domain.SurveyFactory;

@Service
@RequiredArgsConstructor
public class SurveyDefaultWriteService implements SurveyWriteService {

    private final SurveyRepository surveyRepository;
    private final SurveyFactory surveyFactory;

    @Override
    @Transactional
    public Survey create(SurveyCreateRequest createRequest) {

        Survey survey = surveyFactory.create(createRequest);

        return surveyRepository.save(survey);
    }
}
