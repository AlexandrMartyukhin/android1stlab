package ru.minilan.helloworldlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOGTAG = "MyLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(LOGTAG, "onCreate()...");
        TextView textViewTodayDay = findViewById(R.id.textViewTodayDay);
        TextView textViewTodayNight = findViewById(R.id.textViewTodayNight);
        TextView textViewTomorrowDay = findViewById(R.id.textViewTomorrowDay);
        TextView textViewTomorrowNight = findViewById(R.id.textViewTomorrowNight);

        //stabs
        textViewTodayDay.setText("10");
        textViewTodayNight.setText("5");
        textViewTomorrowDay.setText("12");
        textViewTomorrowNight.setText("6");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(LOGTAG, "onStart()...");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(LOGTAG, "onRestoreInstanceState(Bundle )...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(LOGTAG, "onResume()...");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(LOGTAG, "onPause()...");

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(LOGTAG, "onSaveInstanceState(Bundle )...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(LOGTAG, "onStop()...");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(LOGTAG, "onDestroy()...");

    }

    // Back button
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //Log.i(LOGTAG, "  Back button pressed");
    }

    // Home button
    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        //Log.i(LOGTAG, "  Home button pressed");
    }
}
