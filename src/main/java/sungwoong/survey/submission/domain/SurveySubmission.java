package sungwoong.survey.submission.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import sungwoong.survey.BaseEntity;
import sungwoong.survey.survey.domain.SurveyId;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class SurveySubmission extends BaseEntity {

    @Embedded
    private SurveyId surveyId;

    private LocalDateTime submittedAt;

    @OneToMany(mappedBy = "submission", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof SurveySubmission surveySubmission)) {
            return false;
        }
        return Objects.equals(getId(), surveySubmission.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
