package com.deprem.alarm.core;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.IBinder;
import android.telephony.SmsManager;
import android.util.Log;

import com.deprem.alarm.database.AppDatabase;

import java.util.List;

public class MyService extends Service {

    static int count = 1;
    private String msg;
    private static BroadcastReceiver mybroadcast;
    public MyService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){

        Location location = getLocation();
        String longi, lati;
        if(location != null){

            longi = Double.toString(location.getLongitude());
            lati = Double.toString(location.getLatitude());
        } else {
            lati = "\'Not Available\'";
            longi = "\'Not Available\'";
        }

        AppDatabase db = AppDatabase.getAppDatabase(getApplicationContext());

        List<String> mobNumber = db.contactDao().getAllContactsNumber();
        SmsManager smsManager = SmsManager.getDefault();

        String gmapLink = "http://maps.google.com/maps?q=" + lati + ","+ longi;
        msg = "I am here at " + gmapLink + ". I need your help! Get to me Soon.";

        for(String number : mobNumber) {
            smsManager.sendTextMessage(number,null, msg, null, null);
            Log.d("MSG", "sent message to " + number);
        }
    }

    @Override
    public void onDestroy(){
        unregisterReceiver(mybroadcast);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);


        return START_STICKY;
    }



    public Location getLocation(){
        boolean gps_enabled = false;
        boolean network_enabled = false;

        LocationManager lm = (LocationManager) getApplicationContext()
                .getSystemService(Context.LOCATION_SERVICE);

        if(lm != null) {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        }

        Location net_loc = null, gps_loc = null, finalLoc = null;

        if (gps_enabled)
            gps_loc = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (network_enabled)
            net_loc = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        if (gps_loc != null && net_loc != null) {

            //smaller the number more accurate result will
            if (gps_loc.getAccuracy() > net_loc.getAccuracy())
                finalLoc = net_loc;
            else
                finalLoc = gps_loc;

            // I used this just to get an idea (if both avail, its upto you which you want to take as I've taken location with more accuracy)

        } else {

            if (gps_loc != null) {
                finalLoc = gps_loc;
            } else if (net_loc != null) {
                finalLoc = net_loc;
            }
        }
        return finalLoc;
    }
}
