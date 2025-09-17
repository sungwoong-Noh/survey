package sungwoong.survey.submission.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@DiscriminatorValue("CHOICE")
public class ChoiceAnswer extends Answer {

    @OneToMany(mappedBy = "choiceAnswer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SelectedChoice> selectedChoices = new HashSet<>();

    @Override
    boolean validate() {
        return false;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (!(o instanceof ChoiceAnswer choiceAnswer)) {
            return false;
        }

        return Objects.equals(getId(), choiceAnswer.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
