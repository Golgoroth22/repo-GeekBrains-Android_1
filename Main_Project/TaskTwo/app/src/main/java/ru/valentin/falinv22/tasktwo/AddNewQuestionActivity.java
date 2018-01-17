package ru.valentin.falinv22.tasktwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import ru.valentin.falinv22.tasktwo.data.FakeDB;
import ru.valentin.falinv22.tasktwo.quiz.Question;

public class AddNewQuestionActivity extends AppCompatActivity {
    private EditText editText;
    private RadioGroup radioGroup;
    private Button addButton;

    private String question = "";
    private boolean answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_question);

        initUI();
    }

    private void initUI() {
        editText = findViewById(R.id.new_question_edittext);

        radioGroup = findViewById(R.id.add_question_radiogroup);

        addButton = findViewById(R.id.add_question_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewQuestion();
            }
        });
    }

    private void addNewQuestion() {
        int message;

        question = editText.getText().toString();
        int id = radioGroup.getCheckedRadioButtonId();
        switch (id) {
            case R.id.radio_yes:
                answer = true;
                break;
            case R.id.radio_no:
                answer = false;
                break;
        }

        if (question.equals("")) {
            message = R.string.add_failed;
        } else {
            message = R.string.add_successfully;
            FakeDB.getInstance(getApplicationContext()).getQuestionList().add(new Question(question, answer));
            Intent intent = new Intent(getApplicationContext(), MainMenuActivity.class);
            startActivity(intent);
        }
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
