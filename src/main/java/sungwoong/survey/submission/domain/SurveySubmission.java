package sungwoong.survey.submission.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import sungwoong.survey.BaseEntity;
import sungwoong.survey.survey.SurveyId;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SurveySubmission extends BaseEntity {


    @Embedded
    private SurveyId surveyId;

    private LocalDateTime submittedAt;

    @OneToMany(mappedBy = "surveySubmission", cascade = {CascadeType.PERSIST})
    private List<Answer> answers = new ArrayList<>();


}
