package ru.valentin.falinv22.tasktwo.data;

import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

import ru.valentin.falinv22.tasktwo.R;
import ru.valentin.falinv22.tasktwo.quiz.Question;

public class FakeDB{
    private static FakeDB ourInstance;

    private static List<Question> questionListForQuizGame;

    public static FakeDB getInstance(Context context1) {
        if (ourInstance == null) {
            ourInstance = new FakeDB(context1);
        }
        return ourInstance;
    }

    private FakeDB(Context context) {
        questionListForQuizGame = new ArrayList<>();
        Resources resources = context.getResources();
        questionListForQuizGame.add(new Question(resources.getString(R.string.q1), resources.getBoolean(R.bool.a1)));
        questionListForQuizGame.add(new Question(resources.getString(R.string.q2), resources.getBoolean(R.bool.a2)));
        questionListForQuizGame.add(new Question(resources.getString(R.string.q3), resources.getBoolean(R.bool.a3)));
        questionListForQuizGame.add(new Question(resources.getString(R.string.q4), resources.getBoolean(R.bool.a4)));
        questionListForQuizGame.add(new Question(resources.getString(R.string.q5), resources.getBoolean(R.bool.a5)));
    }

    public List<Question> getQuestionList() {
        return questionListForQuizGame;
    }
}
