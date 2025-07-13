package sungwoong.survey.survey.adaptor.web.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class SurveyCreateRequest {

    @NotBlank(message = "설문조사 제목은 필수입니다.")
    @Size(min = 1, max = 100, message = "설문조사 제목은 1글자 이상 100글자 이하여야 합니다.")
    private String title;

    @NotBlank(message = "설문조사 설명은 필수입니다.")
    @Size(min = 1, max = 700, message = "설문조사 설명은 1글자 이상 700글자 이하여야 합니다.")
    private String description;

    @Valid
    @NotNull
    @Size(min = 1, max = 10, message = "질문은 1개 이상, 10개 이하여야 합니다.")
    private List<QuestionCreateRequest> questionCreateRequestList;

}
