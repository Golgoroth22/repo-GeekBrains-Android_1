package ru.valentin.falinv22.tasktwo.quiz;

public class Question {
    private boolean answer;
    private String question;

    public Question(String question, boolean answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public boolean getAnswer() {
        return answer;
    }
}
