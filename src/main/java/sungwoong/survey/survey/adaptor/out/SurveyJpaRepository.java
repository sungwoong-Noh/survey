package sungwoong.survey.survey.adaptor.out;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sungwoong.survey.survey.domain.Survey;

public interface SurveyJpaRepository extends JpaRepository<Survey, Long> {

    @Query(value = """
            SELECT s 
            FROM Survey s
            WHERE s.title LIKE %:keyword% OR s.description LIKE %:keyword%
            """,
            countQuery = """
            SELECT COUNT(DISTINCT s)
            FROM Survey s
            LEFT JOIN s.questions q
            WHERE s.title LIKE %:keyword%
               OR s.description LIKE %:keyword%
               OR q.questionText LIKE %:keyword%
            """)
    Page<Survey> searchList(@Param("keyword") String keyword, Pageable pageable);
}
