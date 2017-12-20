package ru.valentin.falinv22.tasktwo;


import android.app.Activity;
import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    public static final String TRUE_ANSWER = "1";
    public static final String FALSE_ANSWER = "0";
    public static final String RIGHT_ANSWERS_PREF = "Верных ответов - ";

    private List<Question> questionList;
    private int rightAnswers = 0;

    public GameLogic(Activity activity) {
        questionList = new ArrayList<>();
        Resources resources = activity.getResources();
        questionList.add(new Question(resources.getString(R.string.a_earth), resources.getString(R.string.q_earth)));
        questionList.add(new Question(resources.getString(R.string.a_robot), resources.getString(R.string.q_robot)));
        questionList.add(new Question(resources.getString(R.string.a_yes), resources.getString(R.string.q_yes)));
    }

    public String getQuestion() {
        int random = (int) Math.random() * questionList.size();
        return questionList.get(random).getQuestion();
    }


    public void takeTheYesAnswer(String question) {
        Question qForDelete = null;
        for (Question q : questionList) {
            if (q.getQuestion().equals(question)) {
                qForDelete = q;
                if (q.getAnswer().equals(TRUE_ANSWER)) {
                    rightAnswers++;
                }
            }
        }
        questionList.remove(qForDelete);
    }

    public void takeTheNoAnswer(String question) {
        Question qForDelete = null;
        for (Question q : questionList) {
            if (q.getQuestion().equals(question)) {
                qForDelete = q;
                if (q.getAnswer().equals(FALSE_ANSWER)) {
                    rightAnswers++;
                }
            }
        }
        questionList.remove(qForDelete);
    }


    public boolean checkStatus() {
        System.out.println(questionList.size() + " size");
        if (questionList.size() == 0) return false;
        return true;
    }

    public String getResult() {
        return String.valueOf(RIGHT_ANSWERS_PREF + rightAnswers);
    }
}
