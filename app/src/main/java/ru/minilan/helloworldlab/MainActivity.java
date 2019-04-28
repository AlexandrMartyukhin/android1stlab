package ru.minilan.helloworldlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    public static final String LOGTAG = "MyLog";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lfragment);
        Log.i(LOGTAG, "MAIN onCreate()...");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(LOGTAG, "MAIN onStart()...");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(LOGTAG, "MAIN onRestoreInstanceState(Bundle )...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(LOGTAG, "MAIN onResume()...");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(LOGTAG, "MAIN onPause()...");

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(LOGTAG, "MAIN onSaveInstanceState(Bundle )...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(LOGTAG, "MAIN onStop()...");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(LOGTAG, "MAIN onDestroy()...");

    }

    // Back button
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //Log.i(LOGTAG, " MAIN  Back button pressed");
    }

    // Home button
    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        //Log.i(LOGTAG, " MAIN  Home button pressed");
    }
}
