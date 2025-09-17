package sungwoong.survey.survey;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sungwoong.survey.BaseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Survey extends BaseEntity {

    private String title;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "survey", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Question> questions = new ArrayList<>();

    Survey(String title, String description, List<Question> questions) {
        this.title = title;
        this.description = description;
        for (Question question : questions) {
            this.addQuestion(question);
        }
        this.createdAt = LocalDateTime.now();
    }

    private void addQuestion(Question question) {
        if (this.questions.size() >= 10) {
            throw new IllegalArgumentException("질문은 10개 이하여야 합니다.");
        }

        this.questions.add(question);
        question.setSurvey(this);
    }

    public static Survey create(String title, String description, List<Question> questions) {

        if (title == null || title.isBlank() || title.length() > 100) {
            throw new IllegalArgumentException("설문조사 제목은 1글자 ~ 100글자 이내로 입력해야 합니다");
        }

        if (description == null || description.isBlank() || description.length() > 700) {
            throw new IllegalArgumentException("설문조사 설명은 1글자 ~ 700글자 이내로 입력해야 합니다");
        }

        if (questions == null || questions.isEmpty() || questions.size() > 10) {
            throw new IllegalArgumentException("설문조사 질문은 1개이상 10개 이하여야 합니다.");
        }

        return new Survey(title, description, questions);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (!(o instanceof Survey survey)) {
            return false;
        }

        // PK가 같다면 같은 객체이다.
        return Objects.equals(getId(), survey.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}