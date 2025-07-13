package sungwoong.survey.survey.application;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sungwoong.survey.survey.adaptor.web.dto.SurveyCreateRequest;
import sungwoong.survey.survey.application.fixture.FixtureCreateRequest;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class SurveyDefaultServiceTest {

    private static Validator validator;

    @BeforeEach
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    @DisplayName("설문조사 등록 요청은 null값이 있으면 안된다.")
    public void survey_createRequest_valid() {
        SurveyCreateRequest request = new SurveyCreateRequest(null, null, null);

        Set<ConstraintViolation<SurveyCreateRequest>> validate = validator.validate(request);

        assertThat(validate).isNotEmpty();
        assertThat(validate).hasSize(3);
        assertThat(validate).extracting(v -> v.getPropertyPath().toString(), ConstraintViolation::getMessage)
                .containsExactlyInAnyOrder(
                        tuple("title", "설문조사 제목은 필수입니다."),
                        tuple("description", "설문조사 설명은 필수입니다."),
                        tuple("questionCreateRequestList", "질문은 필수로 입니다.")
                );
    }

    @Test
    @DisplayName("설문조사 등록 요청의 제목과 설명, 질문 개수는 제한이 있다.")
    public void survey_createRequest_valid2() {
        SurveyCreateRequest request = new SurveyCreateRequest("a".repeat(101), "a".repeat(701), null);
        Set<ConstraintViolation<SurveyCreateRequest>> violations = validator.validate(request);


        assertThat(violations).isNotEmpty();
        assertThat(violations).hasSize(3);
        assertThat(violations).extracting(v -> v.getPropertyPath().toString(), ConstraintViolation::getMessage)
                .containsExactlyInAnyOrder(
                        tuple("title", "설문조사 제목은 1글자 이상 100글자 이하여야 합니다."),
                        tuple("description", "설문조사 설명은 1글자 이상 700글자 이하여야 합니다."),
                        tuple("questionCreateRequestList", "질문은 필수로 입니다.")
                );
    }

    @Test
    @DisplayName("설문조사 질문은 10개 이상 등록 할 수 없다")
    public void survey_createRequest_valid3() {
        SurveyCreateRequest surveyCreateRequest = FixtureCreateRequest.surveyCreateRequest_questionOver();

        Set<ConstraintViolation<SurveyCreateRequest>> violations = validator.validate(surveyCreateRequest);

        assertThat(violations).isNotEmpty();
        assertThat(violations).hasSize(3);
        assertThat(violations).extracting(v -> v.getPropertyPath().toString(), ConstraintViolation::getMessage)
                .containsExactlyInAnyOrder(
                        tuple("title", "설문조사 제목은 1글자 이상 100글자 이하여야 합니다."),
                        tuple("description", "설문조사 설명은 1글자 이상 700글자 이하여야 합니다."),
                        tuple("questionCreateRequestList", "질문은 필수로 입니다.")
                );
    }
}