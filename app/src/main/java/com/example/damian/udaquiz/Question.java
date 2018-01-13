package com.example.damian.udaquiz;

/**
 * Created by Damian on 13/01/2018.
 */

public class Question {

    private int numberQuestion;
    private String questionText;
    private String firstAnswer, secondAnswer, thirdAnswer, fourthAnswer;
    private TYPE_OF_ANSWERS typeOfAnswers;
    private String answer;
    private String correctAnswer;

    public Question(int numberQuestion, String questionText, String firstAnswer, String secondAnswer, String thirdAnswer, String fourthAnswer, TYPE_OF_ANSWERS typeOfAnswers, String correctAnswer) {
        this.numberQuestion = numberQuestion;
        this.questionText = questionText;
        this.firstAnswer = firstAnswer;
        this.secondAnswer = secondAnswer;
        this.thirdAnswer = thirdAnswer;
        this.fourthAnswer = fourthAnswer;
        this.typeOfAnswers = typeOfAnswers;
        this.correctAnswer = correctAnswer;
        this.answer = " ";
    }


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getNumberQuestion() {
        return numberQuestion;
    }

    public void setNumberQuestion(int numberQuestion) {
        this.numberQuestion = numberQuestion;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getFirstAnswer() {
        return firstAnswer;
    }

    public void setFirstAnswer(String firstAnswer) {
        this.firstAnswer = firstAnswer;
    }

    public String getSecondAnswer() {
        return secondAnswer;
    }

    public void setSecondAnswer(String secondAnswer) {
        this.secondAnswer = secondAnswer;
    }

    public String getThirdAnswer() {
        return thirdAnswer;
    }

    public void setThirdAnswer(String thirdAnswer) {
        this.thirdAnswer = thirdAnswer;
    }

    public String getFourthAnswer() {
        return fourthAnswer;
    }

    public void setFourthAnswer(String fourthAnswer) {
        this.fourthAnswer = fourthAnswer;
    }

    public TYPE_OF_ANSWERS getTypeOfAnswers() {
        return typeOfAnswers;
    }

    public void setTypeOfAnswers(TYPE_OF_ANSWERS typeOfAnswers) {
        this.typeOfAnswers = typeOfAnswers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
