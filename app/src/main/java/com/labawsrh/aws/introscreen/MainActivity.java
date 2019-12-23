package com.labawsrh.aws.introscreen;


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
    private String ses="Lütfen, 5 saniye içerisinde telefonunuzu düz bir zemine koyunuz. 5... 4... 3... 2... 1... 0. Alarm başlatılıyor.";
    TextView t1;
    ImageButton b1;
    ImageButton b2;
    CountDownTimer countDownTimer;
    ImageView imageView;
    Random r;
    int[] images = {R.drawable.hayatucgenigorsel1, R.drawable.hayatucgenigorsel2, R.drawable.hayatucgenigorsel3, R.drawable.hayatucgenigorsel4};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView2);
        Random r = new Random();

        imageView.setImageResource(images[r.nextInt(images.length)]);

        t1 = findViewById(R.id.textView);
        b1 = findViewById(R.id.alarmbuton);

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

                t1.setTextSize(22f);
                t1.setText("Telefonunuzu düz bir zemine koyunuz");

                if (millisUntilFinished < 6000){
                    t1.setTextSize(35f);
                    t1.setText(millisUntilFinished/1000 + "" );
                }

            }

            @Override
            public void onFinish() {
                t1.setText("Alarm Başlatılıyor");
                Intent gecis = new Intent(MainActivity.this,AlarmEkrani.class);
                startActivity(gecis);
                finish();



            }
        };
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                speak();

            }
        });

        gecisyap();
        gecisyapiki();


    }


    private void speak(){
        String text = ses.toString();
        mTTS.setSpeechRate(0.90f);

        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
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
                Intent gecis = new Intent(MainActivity.this,HayatUcgeni.class);
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
                Intent gecis = new Intent(MainActivity.this,UygulamaBilgi.class);
                startActivity(gecis);
                finish();
            }
        });
    }

}

