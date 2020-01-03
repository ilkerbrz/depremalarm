package com.deprem.alarm.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.deprem.alarm.MainActivity;
import com.deprem.alarm.R;

public class HomeActivity extends AppCompatActivity {

    FragmentManager fm;;
    Fragment fragment;
    FragmentTransaction fragmentTransaction;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        // add the tip of the day fragment
        fm = getSupportFragmentManager();

        fragment = fm.findFragmentById(R.id.fragment_container);

        if(fragment == null) {
//            fragment = new TipOfTheDayFragment();
            fragment = new ContactsConfigFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }




        fragment = new ContactsConfigFragment();
        fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment).commit();



        // start service to starting a broadcast receiver


    }


    @Override
    public void onBackPressed() {

        Intent gecis = new Intent(HomeActivity.this, MainActivity.class);
        startActivity(gecis);
        finish();
        super.onBackPressed();
    }





}
