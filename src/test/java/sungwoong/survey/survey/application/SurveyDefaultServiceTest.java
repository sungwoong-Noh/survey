package sungwoong.survey.survey.application;


import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sungwoong.survey.survey.SurveyFactory;
import sungwoong.survey.survey.port.required.SurveyJpaRepository;

@ExtendWith(MockitoExtension.class)
class SurveyDefaultServiceTest {

    @InjectMocks
    private SurveyDefaultService surveyDefaultService;

    @Mock
    private SurveyFactory surveyFactory;

    @Mock
    private SurveyJpaRepository surveyRepository;


}