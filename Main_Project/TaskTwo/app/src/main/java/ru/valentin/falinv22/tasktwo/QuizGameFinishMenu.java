package ru.valentin.falinv22.tasktwo;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizGameFinishMenu extends AppCompatActivity {
    private Button goToMenuButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_game_finish_activity);

        resultTextView = (TextView) findViewById(R.id.result_text_view);

        resultTextView.setText(getIntent().getStringExtra(QuizGameActivity.RESULT));

        goToMenuButton = (Button) findViewById(R.id.quiz_final_button);
        goToMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToStartMenu = new Intent(getApplicationContext(), StartMenuActivity.class);
                intentToStartMenu.putExtra(QuizGameActivity.RESULT, QuizGameActivity.getQuizGameResult());
                startActivity(intentToStartMenu);
            }
        });
    }
}
