package sungwoong.survey.survey;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public record QuestionId(@Column(name = "question_id") Long questionId) implements Serializable {
}
