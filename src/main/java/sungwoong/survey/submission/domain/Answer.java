package sungwoong.survey.submission.domain;

import jakarta.persistence.*;
import lombok.Getter;
import sungwoong.survey.BaseEntity;

@Getter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "answer_type")
public abstract class Answer extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_submission_id")
    private SurveySubmission submission;

    @Embedded
    private QuestionSnapshot questionSnapshot;

    abstract boolean validate();

}
