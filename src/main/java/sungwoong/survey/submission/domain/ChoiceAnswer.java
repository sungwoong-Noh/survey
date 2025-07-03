package sungwoong.survey.submission.domain;

import jakarta.persistence.Entity;
import sungwoong.survey.BaseEntity;

@Entity
public class ChoiceAnswer extends BaseEntity {

    private String choiceValue;

}
