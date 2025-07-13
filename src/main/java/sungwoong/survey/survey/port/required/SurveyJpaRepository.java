package sungwoong.survey.survey.port.required;

import org.springframework.data.jpa.repository.JpaRepository;
import sungwoong.survey.survey.Survey;

public interface SurveyJpaRepository extends JpaRepository<Survey, Long> {
}
