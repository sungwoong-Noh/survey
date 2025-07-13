package sungwoong.survey.survey.adaptor.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sungwoong.survey.survey.Survey;
import sungwoong.survey.survey.adaptor.web.dto.SurveyCreateRequest;
import sungwoong.survey.survey.port.provider.SurveyWriteService;

@RestController
@RequestMapping("/v1/api/survey")
@RequiredArgsConstructor
public class SurveyController {
    private final SurveyWriteService surveyWriteService;

    @PostMapping
    public ResponseEntity<Survey> create(@RequestParam @Valid SurveyCreateRequest createRequest) {

        Survey survey = surveyWriteService.create(createRequest);

        return ResponseEntity.ok(survey);
    }

}
