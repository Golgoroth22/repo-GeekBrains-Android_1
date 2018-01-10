package ru.valentin.falinv22.tasktwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class AddNewQuestionActivity extends AppCompatActivity {
    private EditText editText;
    private RadioGroup radioGroup;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_question);

        initUI();
    }

    private void initUI() {
        editText = findViewById(R.id.new_question_edittext);

        radioGroup = findViewById(R.id.add_question_radiogroup);
        int id = radioGroup.getCheckedRadioButtonId();
        switch (id) {
            case R.id.radio_yes:
                // TODO: 10.01.2018
                break;
            case R.id.radio_no:
                // TODO: 10.01.2018
                break;
        }

        addButton = findViewById(R.id.add_question_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 10.01.2018
            }
        });
    }
}
