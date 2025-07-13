package sungwoong.survey.survey.port.required;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import sungwoong.survey.survey.Survey;
import sungwoong.survey.survey.SurveyFactory;
import sungwoong.survey.survey.adaptor.web.dto.QuestionCreateRequest;
import sungwoong.survey.survey.adaptor.web.dto.SurveyCreateRequest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(SurveyFactory.class)
class SurveyJpaRepositoryTest {

    @Autowired
    SurveyJpaRepository surveyJpaRepository;

    @Autowired
    SurveyFactory surveyFactory;

    @Autowired
    EntityManager entityManager;


    @Test
    public void createSurvey() {

        List<QuestionCreateRequest> questionCreateRequests = List.of(new QuestionCreateRequest("어떤 햄버거를 좋아하시나요?", "", "SHORT_TEXT", true, null));
        SurveyCreateRequest surveyCreateRequest = new SurveyCreateRequest("햄버거 선호도 조사", "햄버거를 다들 얼마나 좋아할까?", questionCreateRequests);

        Survey survey = surveyFactory.create(surveyCreateRequest);

        assertThat(survey.getId()).isNull();

        Survey save = surveyJpaRepository.save(survey);
        Long saveId = save.getId();

        assertThat(survey.getId()).isNotNull();

        entityManager.flush();
        entityManager.clear();

        Survey findSurvey = surveyJpaRepository.findById(saveId).orElseThrow();

        assertThat(findSurvey.getId()).isNotNull();
        assertThat(findSurvey.getQuestions()).isNotNull();
        assertThat(findSurvey.getQuestions()).hasSize(1);
    }

}