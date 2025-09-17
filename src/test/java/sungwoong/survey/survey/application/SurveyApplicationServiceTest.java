package sungwoong.survey.survey.application;


import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sungwoong.survey.survey.adaptor.out.SurveyJpaRepository;

@ExtendWith(MockitoExtension.class)
class SurveyApplicationServiceTest {

    @InjectMocks
    private SurveyApplicationService surveyApplicationService;


    @Mock
    private SurveyJpaRepository surveyRepository;


}