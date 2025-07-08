package sungwoong.survey.survey;

import org.springframework.data.jpa.repository.JpaRepository;
import sungwoong.survey.survey.domain.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
