package sungwoong.survey.survey;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import sungwoong.survey.BaseEntity;

@Getter
@ToString(callSuper = true)
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Choice extends BaseEntity {

    private String value;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    void setQuestion(Question question) {
        this.question = question;
    }

    Choice(String value) {
        this.value = value;
    }

    public static Choice create(String value) {

        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("선택지 값 입력은 필수입니다.");
        }

        if (value.length() > 50) {
            throw new IllegalArgumentException("선택지 값은 50자 이하로 입력해주세요.");
        }

        return new Choice(value);
    }

}
