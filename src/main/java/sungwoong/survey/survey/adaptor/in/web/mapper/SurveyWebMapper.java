package sungwoong.survey.survey.adaptor.in.web.mapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import sungwoong.survey.survey.adaptor.in.web.dto.*;
import sungwoong.survey.survey.domain.Choice;
import sungwoong.survey.survey.domain.Question;
import sungwoong.survey.survey.domain.Survey;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public final class SurveyWebMapper {


    public Survey createRequestToEntity(SurveyCreateRequest surveyRequest) {

        List<Question> questions = createQuestionsToEntityList(surveyRequest.questionCreateRequestList());

        return Survey.create(surveyRequest.title(), surveyRequest.description(), questions);
    }


    private List<Question> createQuestionsToEntityList(List<QuestionCreateRequest> questionRequests) {

        return questionRequests.stream()
                .map(this::createQuestionToEntity)
                .collect(Collectors.toList());
    }


    private Question createQuestionToEntity(QuestionCreateRequest questionRequest) {

        List<Choice> choices = createChoicesToEntityList(questionRequest.choiceCreateRequestList());

        return Question.create(
                questionRequest.questionText(),
                questionRequest.description(),
                questionRequest.getQuestionTypeEnum(),
                questionRequest.isRequired(),
                choices);
    }


    private List<Choice> createChoicesToEntityList(List<ChoiceCreateRequest> choiceRequests) {

        if (choiceRequests == null) {
            return new ArrayList<>();
        }

        return choiceRequests.stream()
                .map(choiceRequest -> Choice.create(choiceRequest.value()))
                .collect(Collectors.toList());
    }


    public SurveyCreateResponse entityToCreateResponse(Survey survey) {
        return SurveyCreateResponse.of(
                survey.getId(),
                survey.getTitle(),
                survey.getDescription(),
                questionEntityToCreateResponses(survey.getQuestions())
        );
    }

    private List<QuestionCreateResponse> questionEntityToCreateResponses(List<Question> questions) {
        return questions.stream()
                .map(q -> QuestionCreateResponse.of(
                        q.getId(),
                        q.getQuestionText(),
                        q.getDescription(),
                        q.getQuestionType().name(),
                        q.isRequired(),
                        choiceEntityToCreateResponses(q.getChoices()))
                ).toList();
    }

    private List<ChoiceCreateResponse> choiceEntityToCreateResponses(List<Choice> choices) {
        return choices.stream()
                .map(c -> ChoiceCreateResponse.of(c.getId(), c.getValue()))
                .toList();
    }
}


