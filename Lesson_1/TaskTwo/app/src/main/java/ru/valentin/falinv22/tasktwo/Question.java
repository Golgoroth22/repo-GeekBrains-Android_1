package ru.valentin.falinv22.tasktwo;

public class Question {
    private String answer;
    private String question;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
