package sungwoong.survey.survey;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public record ChoiceId(@Column(name = "choice_id") Long choiceId) implements Serializable {
}
