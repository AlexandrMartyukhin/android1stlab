package ru.minilan.helloworldlab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Log.i(MainActivity.LOGTAG, "SECOND - onCreate()...");

        TextView textviewheadertown = findViewById(R.id.textviewheadertown);
        TextView textViewTodayDay = findViewById(R.id.textViewTodayDay);
        TextView textViewTodayNight = findViewById(R.id.textViewTodayNight);
        TextView textViewTomorrowDay = findViewById(R.id.textViewTomorrowDay);
        TextView textViewTomorrowNight = findViewById(R.id.textViewTomorrowNight);

        String header = getResources().getText(R.string.app_header_in_town_X)+" "+
                getIntent().getExtras().getString(MainActivity.TOWN);
        textviewheadertown.setText(header);


        //stabs
        textViewTodayDay.setText("10");
        textViewTodayNight.setText("5");
        textViewTomorrowDay.setText("12");
        textViewTomorrowNight.setText("6");
        Log.i(MainActivity.LOGTAG,"  Show Pressure - "+String.valueOf(getIntent().getExtras().getBoolean(MainActivity.PRESSURE)));
        Log.i(MainActivity.LOGTAG,"  Show Humidity - "+String.valueOf(getIntent().getExtras().getBoolean(MainActivity.HUMIDITY)));
        Log.i(MainActivity.LOGTAG,"  Show WindSpeed - "+String.valueOf(getIntent().getExtras().getBoolean(MainActivity.WINDSPEED)));
        Log.i(MainActivity.LOGTAG,"  Show WindDirection - "+String.valueOf(getIntent().getExtras().getBoolean(MainActivity.WINDDIR)));
        Log.i(MainActivity.LOGTAG,"  Show Precipitation - "+String.valueOf(getIntent().getExtras().getBoolean(MainActivity.PRECIPITATION)));


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(MainActivity.LOGTAG, "SECOND onStart()...");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(MainActivity.LOGTAG, "SECOND onRestoreInstanceState(Bundle )...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(MainActivity.LOGTAG, "SECOND onResume()...");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(MainActivity.LOGTAG, "SECOND onPause()...");

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(MainActivity.LOGTAG, "SECOND onSaveInstanceState(Bundle )...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(MainActivity.LOGTAG, "SECOND onStop()...");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(MainActivity.LOGTAG, "SECOND onDestroy()...");

    }

}
