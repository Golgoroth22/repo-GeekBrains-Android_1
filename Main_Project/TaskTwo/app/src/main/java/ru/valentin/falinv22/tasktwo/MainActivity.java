package ru.valentin.falinv22.tasktwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private GameLogic gameLogic;
    private TextView question;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameLogic = new GameLogic(this);
        question = (TextView) findViewById(R.id.question);
        question.setText(gameLogic.getQuestion());
    }

    public void clickYesButton(View view) {
        String currentQuestion = String.valueOf(question.getText());
        gameLogic.takeTheYesAnswer(currentQuestion);
        if (gameLogic.checkStatus()) {
            question.setText(gameLogic.getQuestion());
        } else {
            showMessage();
        }
    }

    public void clickNoButton(View view) {
        String currentQuestion = String.valueOf(question.getText());
        gameLogic.takeTheNoAnswer(currentQuestion);
        if (gameLogic.checkStatus()) {
            question.setText(gameLogic.getQuestion());
        } else {
            showMessage();
        }
    }

    public void clickNextButton(View view) {
        question.setText(gameLogic.getQuestion());
    }

    public void clickForwardButton(View view) {
        question.setText(gameLogic.getQuestion());
    }

    public void showMessage() {
        if (toast != null) {
            toast.cancel();
        }
        String result = gameLogic.getResult();
        toast = Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        Intent i = new Intent(this, this.getClass());
        finish();
        this.startActivity(i);
    }
}
