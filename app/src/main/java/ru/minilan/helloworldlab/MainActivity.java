package ru.minilan.helloworldlab;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.support.v7.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    public static final String LOGTAG = "MyLog";
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lfragment);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //listView.setNestedScrollingEnabled(true);// enable scrolling listview in NestedView !!!

        Log.i(LOGTAG, "MAIN onCreate()...");
    }


    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //

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
