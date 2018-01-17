package ru.valentin.falinv22.tasktwo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import ru.valentin.falinv22.tasktwo.data.FakeDB;
import ru.valentin.falinv22.tasktwo.quiz.Question;

public class QuestionsListFragment extends Fragment {
    public static final String ANSWER_PREF = "Ответ - ";
    public static final String QUESTION = "question";
    public static final String ANSWER = "answer";
    public static final String YES = "ДА";
    public static final String NO = "НЕТ";
    private ListView questionListView;
    private ArrayList<Question> db;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        db = new ArrayList<>();
        db.addAll(FakeDB.getInstance(getContext()).getQuestionList());

        View layout = inflater.inflate(R.layout.fragment_questions_list, container, false);

        FloatingActionButton fab = (FloatingActionButton) layout.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AddNewQuestionActivity.class);
                startActivity(intent);
            }
        });

        initUI(layout);
        return layout;
    }

    private void initUI(View layout) {
        questionListView = layout.findViewById(R.id.questions_list);

        ArrayList<HashMap<String, String>> dbList = new ArrayList<>();
        HashMap<String, String> map;

        for (int i = 0; i < FakeDB.getInstance(getContext()).getQuestionList().size(); i++) {
            map = new HashMap<>();
            String q = FakeDB.getInstance(getContext()).getQuestionList().get(i).getQuestion();
            boolean a = FakeDB.getInstance(getContext()).getQuestionList().get(i).getAnswer();
            map.put(QUESTION, q);
            if (a) map.put(ANSWER, ANSWER_PREF + YES);
            if (!a) map.put(ANSWER, ANSWER_PREF + NO);
            dbList.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(getContext(), dbList, android.R.layout.simple_list_item_2,
                new String[]{QUESTION, ANSWER},
                new int[]{android.R.id.text1, android.R.id.text2});
        questionListView.setAdapter(adapter);
    }

}
