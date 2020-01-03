package com.deprem.alarm;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class AlarmEkraniActivity extends AppCompatActivity implements SensorEventListener {
    Button button;

    SensorManager sensorYoneticisi;
    TextView txt1,txt2,txt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_ekrani);

        txt1=(TextView)findViewById(R.id.textView5);
        txt2=(TextView)findViewById(R.id.textView11);
        txt3=(TextView)findViewById(R.id.textView13);




        sensorYoneticisi =(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        Sensor yonSensor=sensorYoneticisi.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        Sensor isik=sensorYoneticisi.getDefaultSensor(Sensor.TYPE_LIGHT);
        Sensor dogrusalaci=sensorYoneticisi.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);

        if(!sensorYoneticisi.registerListener((SensorEventListener) this,yonSensor,SensorManager.SENSOR_DELAY_FASTEST)){
            Toast.makeText(this, "Sensör Çalışmıyor....", Toast.LENGTH_SHORT).show();
        }





    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        txt1.setText("X :" + sensorEvent.values[0]);
        txt2.setText("Y :" + sensorEvent.values[1]);
        txt3.setText("Z :" + sensorEvent.values[2]);

        if (sensorEvent.values[2] < 5) {

            Toast.makeText(this, "Telefonu eline aldın", Toast.LENGTH_SHORT).show();

        }
        else if ((sensorEvent.values[2] > 8) &&(sensorEvent.values[0]>0.04)&&(sensorEvent.values[1]>0.3)) {

            Toast.makeText(this, "deprem oluyor", Toast.LENGTH_SHORT).show();

            Intent gecis = new Intent(AlarmEkraniActivity.this, DepremAlgilandi.class);
            startActivity(gecis);
            finish();

        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorYoneticisi.unregisterListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}

