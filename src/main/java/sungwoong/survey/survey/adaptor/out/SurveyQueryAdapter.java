package sungwoong.survey.survey.adaptor.out;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sungwoong.survey.survey.application.port.required.SurveyQueryPort;
import sungwoong.survey.survey.domain.Survey;

@Slf4j
@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SurveyQueryAdapter implements SurveyQueryPort {

    private final SurveyJpaRepository surveyJpaRepository;

    @Override
    public Survey findById(Long surveyId) {
        return surveyJpaRepository.findById(surveyId).orElseThrow(() -> new IllegalArgumentException("설문조사를 찾을 수 없습니다."));
    }
}
