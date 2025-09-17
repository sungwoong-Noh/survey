package sungwoong.survey.survey.adaptor.in.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sungwoong.survey.survey.adaptor.in.web.dto.SurveyCreateRequest;
import sungwoong.survey.survey.adaptor.in.web.mapper.SurveyWebMapper;
import sungwoong.survey.survey.application.port.provider.SurveyUseCase;
import sungwoong.survey.survey.domain.Survey;

@RestController
@RequestMapping("/v1/api/survey")
@RequiredArgsConstructor
public class SurveyController {

    private final SurveyUseCase surveyUseCase;

    private final SurveyWebMapper surveyWebMapper;

    @PostMapping
    public ResponseEntity<Survey> create(@RequestParam @Valid SurveyCreateRequest createRequest) {

        Survey survey = surveyUseCase.create(surveyWebMapper.createRequestToEntity(createRequest));

        return ResponseEntity.ok(survey);
    }

}
