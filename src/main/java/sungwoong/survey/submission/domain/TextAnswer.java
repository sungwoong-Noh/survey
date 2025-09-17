package sungwoong.survey.submission.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
@DiscriminatorValue("TEXT")
public class TextAnswer extends Answer{

    private String value;

    @Override
    boolean validate() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof TextAnswer textAnswer)) {
            return false;
        }

        return Objects.equals(getId(), textAnswer.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
