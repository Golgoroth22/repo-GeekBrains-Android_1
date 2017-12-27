package ru.valentin.falinv22.tasktwo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ru.valentin.falinv22.tasktwo.R;

public class StopwatchActivity extends AppCompatActivity implements View.OnClickListener {
    private int seconds = 0;
    private boolean running;
    private Button res;
    private Button str;
    private Button stp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        res = (Button) findViewById(R.id.reset_button);
        str = (Button) findViewById(R.id.start_button);
        stp = (Button) findViewById(R.id.stop_button);
        res.setOnClickListener(this);
        str.setOnClickListener(this);
        stp.setOnClickListener(this);
        runTimer();
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
