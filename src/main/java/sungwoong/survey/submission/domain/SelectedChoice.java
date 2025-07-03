package sungwoong.survey.submission.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import sungwoong.survey.BaseEntity;

import java.util.Objects;

@Entity
public class SelectedChoice extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "choice_answer_id")
    private ChoiceAnswer choiceAnswer;

    @Embedded
    private ChoiceSnapshot choiceSnapshot;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof SelectedChoice)) return false;
        SelectedChoice that = (SelectedChoice) o;
        // choiceSnapshot이 null이 아님을 보장하고, 스냅샷의 내용으로 비교
        return choiceSnapshot != null && Objects.equals(choiceSnapshot, that.choiceSnapshot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(choiceSnapshot);
    }
}