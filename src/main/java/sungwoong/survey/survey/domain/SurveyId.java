package sungwoong.survey.survey.domain;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public record SurveyId(Long surveyId) implements Serializable {

}
