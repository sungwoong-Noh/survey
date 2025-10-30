package sungwoong.survey.survey.adaptor.out;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;
import sungwoong.survey.survey.application.port.required.SurveyQueryPort;
import sungwoong.survey.survey.domain.Survey;

@Slf4j
@Repository
@RequiredArgsConstructor
public class SurveyQueryAdapter implements SurveyQueryPort {

    private final SurveyJpaRepository surveyJpaRepository;

    @Override
    public Survey findById(Long surveyId) {
        return surveyJpaRepository.findById(surveyId).orElseThrow(() -> new IllegalArgumentException("설문조사를 찾을 수 없습니다."));
    }

    @Override
    public Page<Survey> searchList(String keyword, Pageable pageable) {
        return surveyJpaRepository.searchList(keyword, pageable);
    }
}
