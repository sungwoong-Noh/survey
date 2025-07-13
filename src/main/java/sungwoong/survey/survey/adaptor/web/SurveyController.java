package sungwoong.survey.survey.adaptor.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import sungwoong.survey.survey.port.provider.SurveyWriteService;

@RestController
@RequiredArgsConstructor
public class SurveyController {
    private final SurveyWriteService surveyWriteService;
}
