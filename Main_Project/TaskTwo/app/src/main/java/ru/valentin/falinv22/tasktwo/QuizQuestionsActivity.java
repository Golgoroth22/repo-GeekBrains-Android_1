package ru.valentin.falinv22.tasktwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import ru.valentin.falinv22.tasktwo.data.FakeDB;
import ru.valentin.falinv22.tasktwo.quiz.Question;

public class QuizQuestionsActivity extends AppCompatActivity {
    private ListView questionListView;
    private ListView answersListView;
    private ArrayList<Question> db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_questions);
        db = new ArrayList<>();
        db.addAll(FakeDB.getInstance(getApplicationContext()).getQuestionList());
        initUI();
    }

    private void initUI() {
        questionListView = findViewById(R.id.questions_list);
        ArrayList<String> questionsList = new ArrayList<>();
        for (Question q : db) {
            questionsList.add(q.getQuestion());
        }
        ArrayAdapter<String> questionsAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, questionsList);
        questionListView.setAdapter(questionsAdapter);

        answersListView = findViewById(R.id.answers_list);
        ArrayList<Boolean> answersList = new ArrayList<>();
        for (Question q : db) {
            answersList.add(q.getAnswer());
        }
        ArrayAdapter<Boolean> answersAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, answersList);
        answersListView.setAdapter(answersAdapter);
    }
}
