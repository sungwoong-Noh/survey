package sungwoong.survey.survey.adaptor.in.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sungwoong.survey.survey.adaptor.in.web.dto.SurveyCreateRequest;
import sungwoong.survey.survey.adaptor.in.web.dto.SurveyCreateResponse;
import sungwoong.survey.survey.adaptor.in.web.mapper.SurveyWebMapper;
import sungwoong.survey.survey.application.port.provider.SurveyUseCase;
import sungwoong.survey.survey.domain.Survey;

import java.net.URI;

@RestController
@RequestMapping("/v1/api/survey")
@RequiredArgsConstructor
public class SurveyController {

    private final SurveyUseCase surveyUseCase;

    private final SurveyWebMapper surveyWebMapper;

    @PostMapping
    public ResponseEntity<SurveyCreateResponse> create(@RequestBody @Valid SurveyCreateRequest createRequest) {

        Survey survey = surveyUseCase.create(surveyWebMapper.createRequestToEntity(createRequest));

        return ResponseEntity
                .created(URI.create("/v1/api/survey/%d".formatted(survey.getId())))
                .body(surveyWebMapper.entityToCreateResponse(survey));
    }

}
