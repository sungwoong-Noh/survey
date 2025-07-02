package sungwoong.survey.survey;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;
import sungwoong.survey.BaseEntity;

@Getter
@ToString(callSuper = true)
@Entity
public class Choice extends BaseEntity {

    private String choiceValue;

    private boolean isDeleted;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private Question question;

}
