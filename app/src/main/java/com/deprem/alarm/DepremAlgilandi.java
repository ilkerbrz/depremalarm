package com.deprem.alarm;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.deprem.alarm.core.MyService;


public class DepremAlgilandi extends AppCompatActivity{
    ImageButton button;
    CountDownTimer countDownTimer;

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_devrede);



        textView = (TextView) findViewById(R.id.textView15);
        countDownTimer = new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                textView.setText("Son " + millisUntilFinished / 1000 + " Saniye");
            }

            public void onFinish() {
                textView.setText("Konumunuz sms olarak atılıyor..");

                Intent service = new Intent(getApplicationContext(), MyService.class);
                getApplicationContext().startService(service);

            }
        }.start();



        button = (ImageButton) findViewById(R.id.iyiyimbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                Intent gecis = new Intent(DepremAlgilandi.this, MainActivity.class);
                startActivity(gecis);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    protected void onDestroy() {
        countDownTimer.cancel();
        super.onDestroy();
    }
}

