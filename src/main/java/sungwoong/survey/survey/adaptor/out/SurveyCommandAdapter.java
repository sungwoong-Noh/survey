package sungwoong.survey.survey.adaptor.out;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import sungwoong.survey.survey.application.port.required.SurveyCommandPort;
import sungwoong.survey.survey.domain.Survey;

@Slf4j
@Repository
@RequiredArgsConstructor
public class SurveyCommandAdapter implements SurveyCommandPort {

    private final SurveyJpaRepository surveyJpaRepository;

    @Override
    public Survey save(Survey survey) {
        return surveyJpaRepository.save(survey);
    }
}

