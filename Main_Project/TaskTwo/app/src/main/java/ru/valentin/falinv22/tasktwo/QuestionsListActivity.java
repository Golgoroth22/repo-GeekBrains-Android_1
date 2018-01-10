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
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import ru.valentin.falinv22.tasktwo.data.FakeDB;
import ru.valentin.falinv22.tasktwo.quiz.Question;

public class QuestionsListActivity extends AppCompatActivity {
    public static final String ANSWER_PREF = "Ответ - ";
    public static final String QUESTION = "question";
    public static final String ANSWER = "answer";
    public static final String YES = "ДА";
    public static final String NO = "НЕТ";
    private ListView questionListView;
    private ArrayList<Question> db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_list);

        db = new ArrayList<>();
        db.addAll(FakeDB.getInstance(getApplicationContext()).getQuestionList());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddNewQuestionActivity.class);
                startActivity(intent);
            }
        });

        initUI();
    }

    private void initUI() {
        questionListView = findViewById(R.id.questions_list);

        ArrayList<HashMap<String, String>> dbList = new ArrayList<>();
        HashMap<String, String> map;

        for (int i = 0; i < FakeDB.getInstance(getApplicationContext()).getQuestionList().size(); i++) {
            map = new HashMap<>();
            String q = FakeDB.getInstance(getApplicationContext()).getQuestionList().get(i).getQuestion();
            boolean a = FakeDB.getInstance(getApplicationContext()).getQuestionList().get(i).getAnswer();
            map.put(QUESTION, q);
            if (a) map.put(ANSWER, ANSWER_PREF + YES);
            if (!a) map.put(ANSWER, ANSWER_PREF + NO);
            dbList.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(), dbList, android.R.layout.simple_list_item_2,
                new String[]{QUESTION, ANSWER},
                new int[]{android.R.id.text1, android.R.id.text2});
        questionListView.setAdapter(adapter);
    }

}
