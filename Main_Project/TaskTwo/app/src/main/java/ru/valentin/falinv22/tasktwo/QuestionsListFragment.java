package ru.valentin.falinv22.tasktwo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ru.valentin.falinv22.tasktwo.data.FakeDB;
import ru.valentin.falinv22.tasktwo.quiz.Question;

public class QuestionsListFragment extends Fragment {
    private static final String deleteMessage = "Вопрос удален!";
    public static final String ANSWER_PREF = "Ответ - ";
    public static final String YES = "ДА";
    public static final String NO = "НЕТ";

    private RecyclerView questionsRecyclerView;
    private QuestionAdapter questionAdapter;
    private ArrayList<Question> db;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        db = new ArrayList<>();
        db.addAll(FakeDB.getInstance(getContext()).getQuestionList());

        View root = inflater.inflate(R.layout.fragment_questions_list, container, false);

        initUI(root);
        return root;
    }

    private void initUI(View rootView) {
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AddNewQuestionActivity.class);
                startActivity(intent);
            }
        });

        questionAdapter = new QuestionAdapter();
        questionsRecyclerView = rootView.findViewById(R.id.question_list_list_recycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        questionsRecyclerView.setLayoutManager(layoutManager);
        questionsRecyclerView.setAdapter(questionAdapter);
    }

    private class QuestionAdapter extends RecyclerView.Adapter<QuestionViewHolder> {

        @Override
        public QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_question_card, parent, false);
            return new QuestionViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(QuestionViewHolder holder, final int position) {
            holder.questionText.setText(db.get(position).getQuestion());

            boolean temp = FakeDB.getInstance(getContext()).getQuestionList().get(position).getAnswer();
            if (temp) holder.questionAnswer.setText(ANSWER_PREF + YES);
            if (!temp) holder.questionAnswer.setText(ANSWER_PREF + NO);

            holder.closeImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FakeDB.getInstance(getContext()).getQuestionList().remove(position);
                    showMessageForDel();
                }
            });
        }

        @Override
        public int getItemCount() {
            if (db != null) {
                return db.size();
            }
            return 0;
        }

        public void showMessageForDel() {
            Toast toast = Toast.makeText(getContext(), deleteMessage, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            Intent intent = new Intent(getContext(), MainMenuActivity.class);
            startActivity(intent);
        }
    }

    private class QuestionViewHolder extends RecyclerView.ViewHolder {
        ImageView closeImage;
        TextView questionText;
        TextView questionAnswer;

        public QuestionViewHolder(View itemView) {
            super(itemView);
            closeImage = itemView.findViewById(R.id.question_card_close);
            questionText = itemView.findViewById(R.id.question_card_question);
            questionAnswer = itemView.findViewById(R.id.question_card_answer);
        }
    }
}
