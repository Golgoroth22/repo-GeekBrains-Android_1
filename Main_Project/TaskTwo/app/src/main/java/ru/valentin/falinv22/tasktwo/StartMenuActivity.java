package ru.valentin.falinv22.tasktwo;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class StartMenuActivity extends AppCompatActivity {
    private Button chooseQuizButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_menu_activity);

        chooseQuizButton = (Button) findViewById(R.id.choose_quiz_button);
        chooseQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), QuizGameActivity.class);
                startActivity(intent);
            }
        });
    }
}
