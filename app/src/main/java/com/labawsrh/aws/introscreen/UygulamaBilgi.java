package com.labawsrh.aws.introscreen;


import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.Locale;

public class UygulamaBilgi extends AppCompatActivity {
    private TextSwitcher textSwitcher;
    private ImageButton nextButton;
    private ImageButton backButton;
    private TextView yazilar;
    private TextToSpeech mTTS;
    private ImageButton speakses;
    private int stringIndex = 0;
    private String[] row = {"Deprem Alarmının Amacı \n\n İstatistikleri incelediğimiz de görüyoruz ki en çok deprem geceleri oluyor. Ve yine istatistiklere göre en çok ölüm oranı olan depremler gece olan depremlerde görülüyor. \n\n Çevremizdeki bir çok deprem yaşamış insanla konuştuğumuzda ve onlara deprem sırasında uyuyan, uyanamayan tanıdıklarınız oldu mu diye sorduğumuzda aldığımız cevaplar bizi çok şaşırttı. Neredeyse sorduğumuz her insanın uyanamayan bir tanıdığı olduğunu veya bizzat sorduğumuz kişinin uyanamadığının cevabını aldık. \n\n", " Biz de bu yüzden bu uygulamayı yaptık. \n\n Anasayfadan Alarmı başlat butonuna tıkladığınızda sizden 5 saniye içerisinde telefonunuzu düz bir zemine koymanızı istiyoruz. \n\n Deprem olduğunda olabildiğince çabuk uyanmanız için uygulama herhangi bir deprem anında normal insanlar için, o insanı uyandıracak yüksek ve şiddetli bir ses, işitme engelli insanlar için de telefonu sürekli titretiyor, ekran ve flash ışını sürekli açıp kapatıyor ve yüksek frekanslı bir ses dalgası gönderiyoruz.", "Deprem olurken uyansak ne olur diyenler için; \n\n" +
            "Dünyanın en tecrübeli kurtarma birimi Amerikan Uluslararası kurtarma ekibinin kurtarma şefi ve afet olayları müdürünün sözlerine göre: Eğer ki bulunduğunuz binadan 15-20 saniye içerisinden çıkamayacaksanız, çıkmaya çalışırsanız yaşama şansınızın yüzde 0 olduğunu söylüyor. \n\n Bu yüzden deprem anında yataktaysanız ve uygulamamızın alarmıyla birlikte uyandıysanız hızlıca yatağınızın yanına düşüp hayat üçgenini yaptığınızda yaşama olasılığınızın yüzde 100 olucağını söylüyor.", "Lütfen öğrenmediyseniz\n\n Uygulamamızın içinden HAYAT üçgenini öğren butonuna tıklayarak HAYAT kurtaran önerilerimizi okuyunuz veya dinleyiniz. \n\n Unutmadan olası bir deprem anında \n\n HER ZAMAN HATIRLAYIN!"};
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uygulama_bilgi);

        speakses = findViewById(R.id.alarmbuton2);
        yazilar = findViewById(R.id.textView9);

        textSwitcher = findViewById(R.id.textSwitcher);
        nextButton = findViewById(R.id.alarmbuton3);
        backButton = findViewById(R.id.alarmbuton5);

        yazilar.setText("Deprem Alarmının Amacı İstatistikleri incelediğimiz de görüyoruz ki en çok deprem geceleri oluyor. Ve yine istatistiklere göre en çok ölüm oranı olan depremler gece olan depremlerde görülüyor. Çevremizdeki bir çok deprem yaşamış insanla konuştuğumuzda ve onlara deprem sırasında uyuyan, uyanamayan tanıdıklarınız oldu mu diye sorduğumuzda aldığımız cevaplar bizi çok şaşırttı. Neredeyse sorduğumuz her insanın uyanamayan bir tanıdığı olduğunu veya bizzat sorduğumuz kişinin uyanamadığının cevabını aldık.");
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stringIndex == row.length - 1) {
                    stringIndex = 0;


                    backButton.setVisibility(v.INVISIBLE);

                    textSwitcher.setText(row[stringIndex]);
                    yazilar.setText(row[stringIndex]);
                } else {
                    textSwitcher.setText(row[++stringIndex]);
                    yazilar.setText(row[stringIndex]);
                    backButton.setVisibility(v.VISIBLE);
                }
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stringIndex == row.length - 1) {
                    stringIndex = 0;
                    backButton.setVisibility(v.INVISIBLE);
                    yazilar.setText(row[stringIndex]);
                    textSwitcher.setText(row[stringIndex]);
                } else {

                    if (stringIndex == 1){
                        backButton.setVisibility(v.INVISIBLE);
                        textSwitcher.setText(row[--stringIndex]);
                        yazilar.setText(row[stringIndex]);
                    }
                    else {
                        textSwitcher.setText(row[--stringIndex]);
                        yazilar.setText(row[stringIndex]);
                    }


                }
            }
        });

        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                textView = new TextView(UygulamaBilgi.this);
                textView.setGravity(Gravity.CENTER_HORIZONTAL);
                return textView;
            }
        });

        textSwitcher.setText(row[stringIndex]);



        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS){
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

        speakses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });


    }
    private void speak(){
        String text = yazilar.getText().toString();
        mTTS.setSpeechRate(1f);

        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);

    }

    @Override
    protected void onDestroy() {

        if (mTTS != null){
            mTTS.stop();
            mTTS.shutdown();
        }
        super.onDestroy();
    }


    @Override
    public void onBackPressed() {

        Intent gecis = new Intent(UygulamaBilgi.this,MainActivity.class);
        startActivity(gecis);
        finish();
        super.onBackPressed();
    }
}