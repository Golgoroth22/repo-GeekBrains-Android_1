package ru.valentin.falinv22.tasktwo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import ru.valentin.falinv22.tasktwo.data.FakeDB;
import ru.valentin.falinv22.tasktwo.quiz.Question;

public class QuestionsListActivity extends AppCompatActivity {
    private ListView questionListView;
    private ArrayList<Question> db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db = new ArrayList<>();
        db.addAll(FakeDB.getInstance(getApplicationContext()).getQuestionList());


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent intent = new Intent(getApplicationContext(), AddNewQuestionActivity.class);
                startActivity(intent);
            }
        });

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
    }

}
