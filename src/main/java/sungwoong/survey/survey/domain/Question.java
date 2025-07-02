package sungwoong.survey.survey.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;
import sungwoong.survey.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString(callSuper = true)
@Entity
public class Question extends BaseEntity {

    private String questionText;

    private String questionDescription;

    @Enumerated(value = EnumType.STRING)
    private QuestionType questionType;

    private boolean isRequired;

    private boolean isDeleted;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "survey_id")
    private Survey survey;

    @OneToMany(mappedBy = "question")
    private List<Choice> choices = new ArrayList<>();

}
