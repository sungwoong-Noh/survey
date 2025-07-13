package sungwoong.survey.survey.adaptor.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ChoiceCreateRequest(
        @NotBlank(message = "선택지 내용은 필수 입니다.") @Size(min = 1, max = 40, message = "선택지 내용은 1글자 이상, 40내 이하여야 합니다.") String value
) {
}
