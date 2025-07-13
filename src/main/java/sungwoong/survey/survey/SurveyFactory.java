package sungwoong.survey.survey;

import org.springframework.stereotype.Component;
import sungwoong.survey.survey.adaptor.web.dto.ChoiceCreateRequest;
import sungwoong.survey.survey.adaptor.web.dto.QuestionCreateRequest;
import sungwoong.survey.survey.adaptor.web.dto.SurveyCreateRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SurveyFactory {

    public Survey create(SurveyCreateRequest surveyRequest) {

        List<Question> questions = createQuestions(surveyRequest.getQuestionCreateRequestList());

        return Survey.create(surveyRequest.getTitle(), surveyRequest.getDescription(), questions);
    }


    private List<Question> createQuestions(List<QuestionCreateRequest> questionRequests) {

        return questionRequests.stream()
                .map(this::createQuestion)
                .collect(Collectors.toList());
    }


    private Question createQuestion(QuestionCreateRequest questionRequest) {

        List<Choice> choices = createChoices(questionRequest.getChoiceCreateRequestList());

        return Question.create(
                questionRequest.getQuestionText(),
                questionRequest.getDescription(),
                questionRequest.getQuestionTypeEnum(),
                questionRequest.getIsRequired(),
                choices);
    }


    private List<Choice> createChoices(List<ChoiceCreateRequest> choiceRequests) {

        if (choiceRequests == null) {
            return new ArrayList<>();
        }

        return choiceRequests.stream()
                .map(choiceRequest -> Choice.create(choiceRequest.getValue()))
                .collect(Collectors.toList());
    }
}
