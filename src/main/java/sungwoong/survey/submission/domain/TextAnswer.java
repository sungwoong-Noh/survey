package sungwoong.survey.submission.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("TEXT")
public class TextAnswer extends Answer{

    private String answerText;

    @Override
    boolean validate() {
        return false;
    }
}
