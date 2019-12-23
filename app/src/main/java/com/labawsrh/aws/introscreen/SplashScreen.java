package com.labawsrh.aws.introscreen;



import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    private static int  GECIS_SURESI= 3000;

    public SplashScreen() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        // TANIMLAMALAR



        // GEÇİŞ
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent gecıs = new Intent(SplashScreen.this,IntroActivity.class);
                startActivity(gecıs);
                finish();

            }
        },GECIS_SURESI);

    }
}
