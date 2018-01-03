package ru.valentin.falinv22.tasktwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class SendMessageActivity extends AppCompatActivity {
    private Spinner selectReceiver;
    private TextView receiverNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        initUI();
    }

    private void initUI() {
        receiverNumber = findViewById(R.id.send_message_view_receiver_number);
        selectReceiver = findViewById(R.id.send_message_view_select);
        selectReceiver.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] choose = getResources().getStringArray(R.array.receivers_list_number);
                receiverNumber.setText(choose[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
