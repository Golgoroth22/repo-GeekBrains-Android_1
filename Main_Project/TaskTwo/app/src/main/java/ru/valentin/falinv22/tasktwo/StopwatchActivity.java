package ru.valentin.falinv22.tasktwo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ru.valentin.falinv22.tasktwo.R;

public class StopwatchActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String CURRENT_SECONDS = "CURRENT_SECONDS";
    public static final String RUN_OR_NOT = "RUN_OR_NOT";
    public static final String TAG = "StopwatchActivity";
    private int seconds = 0;
    private boolean running;
    private Button res;
    private Button str;
    private Button stp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Start onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt(CURRENT_SECONDS);
            running = savedInstanceState.getBoolean(RUN_OR_NOT);
        }

        createUI();
        runTimer();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Start onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Start onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Start onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Start onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Start onDestroy()");
    }

    private void createUI() {
        res = (Button) findViewById(R.id.reset_button);
        str = (Button) findViewById(R.id.start_button);
        stp = (Button) findViewById(R.id.stop_button);
        res.setOnClickListener(this);
        str.setOnClickListener(this);
        stp.setOnClickListener(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CURRENT_SECONDS, seconds);
        outState.putBoolean(RUN_OR_NOT, running);
    }

    private void runTimer() {
        final TextView timeView = (TextView) findViewById(R.id.timer_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                String time = String.format("%d:%02d:%02d",
                        hours, minutes, secs);
                timeView.setText(time);
                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }


    @Override
    public void onClick(View view) {
        if (view.equals(res)) {
            running = false;
            seconds = 0;
            return;
        }
        if (view.equals(str)) {
            running = true;
        }
        if (view.equals(stp)) {
            running = false;
        }
    }
}
