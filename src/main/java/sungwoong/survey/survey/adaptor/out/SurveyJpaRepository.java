package sungwoong.survey.survey.adaptor.out;

import org.springframework.data.jpa.repository.JpaRepository;
import sungwoong.survey.survey.domain.Survey;

public interface SurveyJpaRepository extends JpaRepository<Survey, Long> {
}
