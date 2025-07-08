package sungwoong.survey.submission.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public record ChoiceSnapshot(
        @Column(name = "original_choice_id") Long choiceId,
        @Column(name = "original_choice_value") String choiceValue) implements Serializable {
}
