package sungwoong.survey.survey;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import sungwoong.survey.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Question extends BaseEntity {

    private String questionText;

    private String description;

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

    Question(String questionText, String description, QuestionType questionType, boolean isRequired, List<Choice> choices) {

        this.questionText = questionText;
        this.description = description;
        this.questionType = questionType;
        this.isRequired = isRequired;

        for (Choice choice : choices) {
            addChoice(choice);
        }
    }

    // 외부에서 사용하는 것을 막기 위해 default 접근제한자로 설정
    void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public static Question create(String questionText, String description, QuestionType questionType, boolean isRequired, List<Choice> choices) {

        if (questionText == null || questionText.isBlank() || questionText.length() > 50) {
            throw new IllegalArgumentException("질문 제목은 1글자 ~ 50글자 이내로 입력해야 합니다");
        }
        if (description != null && description.length() > 50) {
            throw new IllegalArgumentException("질문 설명은 50글자 이내로 입력해야 합니다");
        }

        if (QuestionType.isTextType(questionType) && choices != null && !choices.isEmpty()) {
            throw new IllegalArgumentException("주관식 질문은 선택지를 가질 수 없습니다.");
        }

        if (QuestionType.isChoiceType(questionType) &&  (choices == null || choices.isEmpty())) {
            throw new IllegalArgumentException("선택 유형의 질문은 선택지를 추가하여야 합니다.");
        }

        if (choices != null && choices.size() > 10) {
            throw new IllegalArgumentException("선택지는 최대 10개까지 추가할 수 있습니다.");
        }

        List<Choice> actualChoices = QuestionType.isTextType(questionType) && choices == null ? new ArrayList<>() : choices;

        return new Question(questionText, description, questionType, isRequired, actualChoices);
    }

    void addChoice(Choice choice) {
        this.choices.add(choice);
        choice.setQuestion(this);
    }
}
