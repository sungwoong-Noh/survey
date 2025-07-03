package sungwoong.survey.submission.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import sungwoong.survey.survey.QuestionType;

import java.io.Serializable;

@Embeddable
public record QuestionSnapshot(

        @Column(name = "original_question_Id") Long questionId,
        @Column(name = "original_question_text") String questionText,
        @Column(name = "original_question_description") String questionDescription,
        @Column(name = "original_question_type") QuestionType questionType
) implements Serializable {
}
