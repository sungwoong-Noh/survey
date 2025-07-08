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

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

}
