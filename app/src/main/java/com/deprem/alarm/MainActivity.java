package com.deprem.alarm;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private TextToSpeech mTTS;
    private TextView tvAlarmDurum;
    private ImageButton ibtnAlarmBaslat;
    private CountDownTimer countDownTimer;
    private ImageView ivHayatUcgeniGorseli;

    private final String ses="Lütfen, 5 saniye içerisinde telefonunuzu düz bir zemine koyunuz. 5... 4... 3... 2... 1... 0. Alarm başlatılıyor.";
    private int[] images = {R.drawable.hayatucgenigorsel1, R.drawable.hayatucgenigorsel2, R.drawable.hayatucgenigorsel3, R.drawable.hayatucgenigorsel4};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random random = new Random();
        ivHayatUcgeniGorseli = findViewById(R.id.imageView2);
        ivHayatUcgeniGorseli.setImageResource(images[random.nextInt(images.length)]);
        tvAlarmDurum = findViewById(R.id.tvAlarmDurum);
        ibtnAlarmBaslat = findViewById(R.id.ibtnAlarmBaslat);

        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = mTTS.setLanguage(new Locale("tr-TR"));

                    if(result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Malesef bu dili destekleyemiyoruz");
                    }
                } else {
                    Log.e("TTS", "Doğrulama başarısız");
                }
            }
        });


        countDownTimer = new CountDownTimer(11000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvAlarmDurum.setTextSize(22f);
                tvAlarmDurum.setText("Telefonunuzu düz bir zemine koyunuz");
                if (millisUntilFinished < 6000){
                    tvAlarmDurum.setTextSize(35f);
                    tvAlarmDurum.setText(millisUntilFinished/1000 + "" );
                }
            }

            @Override
            public void onFinish() {
                tvAlarmDurum.setText("Alarm Başlatılıyor");
                Intent gecis = new Intent(MainActivity.this, AlarmEkraniActivity.class);
                startActivity(gecis);
                finish();
            }
        };

        ibtnAlarmBaslat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });

        gecisyap();
        gecisyapiki();
    }


    private void speak(){
        mTTS.setSpeechRate(0.90f);
        mTTS.speak(ses, TextToSpeech.QUEUE_FLUSH, null);
        countDownTimer.start();
    }

    @Override
    protected void onDestroy() {
        if (mTTS != null){
            mTTS.stop();
            mTTS.shutdown();
        }
        super.onDestroy();
    }

    private void gecisyap(){
        ImageButton b3 = (ImageButton) findViewById(R.id.alarmbuton2);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecis = new Intent(MainActivity.this, HayatUcgeniActivity.class);
                startActivity(gecis);
                finish();
            }
        });
    }
    private void gecisyapiki(){
        ImageButton b4 = (ImageButton) findViewById(R.id.alarmbuton4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecis = new Intent(MainActivity.this, UygulamaBilgiActivity.class);
                startActivity(gecis);
                finish();
            }
        });
    }

}

