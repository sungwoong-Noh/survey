package sungwoong.survey.survey;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public record SurveyId(Long surveyId) implements Serializable {

}
