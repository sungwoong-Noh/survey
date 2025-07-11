package sungwoong.survey.submission.domain;

import jakarta.persistence.*;
import lombok.Getter;
import sungwoong.survey.BaseEntity;
import sungwoong.survey.survey.domain.QuestionId;

@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "answer_type")
public abstract class Answer extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_submission_id")
    private SurveySubmission submission;

    @Embedded
    private QuestionId questionId;

    @Embedded
    private QuestionSnapshot questionSnapshot;

    abstract boolean validate();

}
