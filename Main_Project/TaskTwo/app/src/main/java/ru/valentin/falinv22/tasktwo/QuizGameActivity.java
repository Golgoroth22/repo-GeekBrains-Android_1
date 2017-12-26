package ru.valentin.falinv22.tasktwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import ru.valentin.falinv22.tasktwo.quiz.QuizGameLogic;

public class QuizGameActivity extends AppCompatActivity {
    public static final String RESULT = "result";
    public static final String TAG = "QuizGameActivity";
    public static final String TAG_FOR_SAVE_GAME_LOGIC = "save_game_logic";
    private static String maxResult = "0";
    private static QuizGameLogic gameLogic;
    private TextView question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_game_activity);
        gameLogic = new QuizGameLogic(this);
        question = (TextView) findViewById(R.id.question);
        question.setText(gameLogic.getQuestion());

        if (savedInstanceState != null) {
            gameLogic = (QuizGameLogic) savedInstanceState.getSerializable(TAG_FOR_SAVE_GAME_LOGIC);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "Вызван onSaveInstanceState");
        outState.putSerializable(TAG_FOR_SAVE_GAME_LOGIC, gameLogic);
    }

    public void clickYesButton(View view) {
        String currentQuestion = String.valueOf(question.getText());
        gameLogic.takeTheYesAnswer(currentQuestion);
        if (gameLogic.checkStatus()) {
            question.setText(gameLogic.getQuestion());
        } else {
            goToFinishMenu();
        }
    }

    public void clickNoButton(View view) {
        String currentQuestion = String.valueOf(question.getText());
        gameLogic.takeTheNoAnswer(currentQuestion);
        if (gameLogic.checkStatus()) {
            question.setText(gameLogic.getQuestion());
        } else {
            goToFinishMenu();
        }
    }

    public void clickNextButton(View view) {
        question.setText(gameLogic.getQuestion());
    }

    public void clickForwardButton(View view) {
        question.setText(gameLogic.getQuestion());
    }

    private void goToFinishMenu() {
        Intent intent = new Intent(getApplicationContext(), QuizGameFinishMenu.class);
        String result = gameLogic.getResult();
        intent.putExtra(RESULT, result);
        checkMax(result);
        startActivity(intent);
    }

    private void checkMax(String res) {
        if (Integer.parseInt(res) > Integer.parseInt(maxResult)) {
            maxResult = res;
        }
    }

    public static String getQuizGameResult() {
        return maxResult;
    }
}
