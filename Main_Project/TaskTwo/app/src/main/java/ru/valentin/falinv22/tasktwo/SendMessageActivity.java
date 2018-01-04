package ru.valentin.falinv22.tasktwo;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class SendMessageActivity extends AppCompatActivity {
    private Spinner selectReceiver;
    private TextView receiverNumber;
    private Button sendMessage;

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

        sendMessage = findViewById(R.id.send_msq_view_button);
        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMsq(view);
            }
        });
    }

    public void sendMsq(View view) {
        String sms = sendMessage.getText().toString();
//        String number = receiverNumber.getText().toString();
//        SmsManager smsManager = SmsManager.getDefault();
//        smsManager.sendTextMessage(number, null, sms, null, null);
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, sms);
        sendIntent.setType("text/plain");

        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(sendIntent);
        }
    }
}
