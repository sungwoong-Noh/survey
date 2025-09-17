package sungwoong.survey.survey.adaptor.in.web.dto;

public record ChoiceCreateResponse(Long id, String value) {

    public static ChoiceCreateResponse of(Long id, String value) {
        return new ChoiceCreateResponse(id, value);
    }
}
