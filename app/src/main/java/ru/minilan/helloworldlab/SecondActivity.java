package ru.minilan.helloworldlab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation == ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }

        if (savedInstanceState == null) {
            Log.i(MainActivity.LOGTAG, "SECOND - savedState == null");
            Log.i(MainActivity.LOGTAG, String.valueOf(getIntent().getExtras().getInt("index")));

            FragmentWeather details = new FragmentWeather();
            details.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction().add(android.R.id.content, details).commit();
        }

        Log.i(MainActivity.LOGTAG, "SECOND - onCreate()...");
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
