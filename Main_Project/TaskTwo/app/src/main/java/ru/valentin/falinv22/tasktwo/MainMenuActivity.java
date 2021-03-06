package ru.valentin.falinv22.tasktwo;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainMenuActivity extends AppCompatActivity {
    private Button chooseQuizButton;
    private Button chooseStopwatchButton;
    private Button chooseQuestionsAnswers;
    private Button chooseWTFButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_menu_activity);

        resultTextView = (TextView) findViewById(R.id.result_text_view);
        resultTextView.setText(getIntent().getStringExtra(QuizGameActivity.RESULT));

        chooseQuizButton = (Button) findViewById(R.id.choose_quiz_button);
        chooseQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), QuizGameActivity.class);
                startActivity(intent);
            }
        });

        chooseQuestionsAnswers = findViewById(R.id.questions_answers_button);
        chooseQuestionsAnswers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                QuestionsListFragment listFragment = new QuestionsListFragment();
                fragmentManager.beginTransaction().add(R.id.main_menu_container, listFragment).commit();
            }
        });

        chooseStopwatchButton = (Button) findViewById(R.id.stopwatch_button);
        chooseStopwatchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StopwatchActivity.class);
                startActivity(intent);
            }
        });

        chooseWTFButton = findViewById(R.id.wtf_button);
        chooseWTFButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SendMessageActivity.class);
                startActivity(intent);
            }
        });
    }
}
