package sungwoong.survey.submission.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import sungwoong.survey.survey.QuestionType;

import java.io.Serializable;

@Embeddable
public record QuestionSnapshot(Long questionId, String questionText, String questionDescription, QuestionType questionType) implements Serializable {
}
