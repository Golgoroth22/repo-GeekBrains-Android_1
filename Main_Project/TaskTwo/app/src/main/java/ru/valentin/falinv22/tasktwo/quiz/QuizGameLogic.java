package ru.valentin.falinv22.tasktwo.quiz;


import android.content.Context;
import android.content.res.Resources;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ru.valentin.falinv22.tasktwo.R;

public class QuizGameLogic implements Serializable {
    public static final boolean TRUE_ANSWER = true;
    public static final boolean FALSE_ANSWER = false;

    private List<Question> questionList;
    private int rightAnswers = 0;

    public QuizGameLogic(Context context) {
        questionList = new ArrayList<>();
        Resources resources = context.getResources();
        questionList.add(new Question(resources.getString(R.string.q1), resources.getBoolean(R.bool.a1)));
        questionList.add(new Question(resources.getString(R.string.q2), resources.getBoolean(R.bool.a2)));
        questionList.add(new Question(resources.getString(R.string.q3), resources.getBoolean(R.bool.a3)));
        questionList.add(new Question(resources.getString(R.string.q4), resources.getBoolean(R.bool.a4)));
        questionList.add(new Question(resources.getString(R.string.q5), resources.getBoolean(R.bool.a5)));
    }

    public String getQuestion() {
        int random = (int) (Math.random() * questionList.size());
        return questionList.get(random).getQuestion();
    }

    public void takeTheYesAnswer(String question) {
        Question qForDelete = null;
        for (Question q : questionList) {
            if (q.getQuestion().equals(question)) {
                qForDelete = q;
                if (q.getAnswer() == TRUE_ANSWER) {
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
                if (q.getAnswer() == FALSE_ANSWER) {
                    rightAnswers++;
                }
            }
        }
        questionList.remove(qForDelete);
    }


    public boolean checkStatus() {
        if (questionList.size() == 0) return false;
        return true;
    }

    public String getResult() {
        return String.valueOf(rightAnswers);
    }
}
