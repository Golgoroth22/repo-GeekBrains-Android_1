package ru.valentin.falinv22.taskone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickColorEffect(View view) {
        spinner = (Spinner) findViewById(R.id.spinner);
        textView2 = (TextView) findViewById(R.id.textView2);
        String color = String.valueOf(spinner.getSelectedItem());
        String colorEffect = new ColorSpec().getEffect(color, this);
        textView2.setText(colorEffect);
    }
}
