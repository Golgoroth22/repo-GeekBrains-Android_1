package ru.valentin.falinv22.taskone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickColorEffect(View view) {
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        String color = String.valueOf(spinner.getSelectedItem());
        textView2.setText(color);
    }
}
