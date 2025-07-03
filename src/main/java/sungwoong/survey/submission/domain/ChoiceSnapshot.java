package sungwoong.survey.submission.domain;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public record ChoiceSnapshot(Long choiceId, String choiceValue) implements Serializable {
}
