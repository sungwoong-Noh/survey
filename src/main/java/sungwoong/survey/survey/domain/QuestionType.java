package sungwoong.survey.survey.domain;

public enum QuestionType {
    SHORT_TEXT,
    LONG_TEXT,
    SINGLE_CHOICE,
    MULTI_CHOICE;

    public static boolean isChoiceType(QuestionType questionType) {

        return questionType == SINGLE_CHOICE || questionType == MULTI_CHOICE;
    }

    public static boolean isTextType(QuestionType questionType) {

        return questionType == SHORT_TEXT || questionType == LONG_TEXT;
    }
}
