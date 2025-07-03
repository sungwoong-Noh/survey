package sungwoong.survey.survey;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id")
    private Survey survey;

    @OneToMany(mappedBy = "question", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Choice> choices = new ArrayList<>();

}
