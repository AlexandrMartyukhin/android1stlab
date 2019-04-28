package ru.minilan.helloworldlab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    public static final String LOGTAG = "MyLog";
    public static final String TOWN = "TOWN";
    public static final String PRESSURE = "PRESSURE";
    public static final String HUMIDITY = "HUMIDITY";
    public static final String WINDSPEED = "WINDSPEED";
    public static final String WINDDIR = "WINDDIR";
    public static final String PRECIPITATION = "PRECIPITATION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lfragment);
        Log.i(LOGTAG, "MAIN onCreate()...");
    }

    public void onClickOkButton(View view) {

        EditText editTextTown = findViewById(R.id.editTextTown);
        CheckBox checkBoxPressure = findViewById(R.id.checkBoxPressure);
        CheckBox checkBoxHumidity = findViewById(R.id.checkBoxHumidity);
        CheckBox checkBoxWindSpeed = findViewById(R.id.checkBoxWindSpeed);
        CheckBox checkBoxWindDirection = findViewById(R.id.checkBoxWindDirection);
        Switch switchPrecipitation = findViewById(R.id.switchPrecipitation);

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra(TOWN, editTextTown.getText().toString());
        intent.putExtra(PRESSURE, checkBoxPressure.isChecked());
        intent.putExtra(HUMIDITY,checkBoxHumidity.isChecked());
        intent.putExtra(WINDSPEED,checkBoxWindSpeed.isChecked());
        intent.putExtra(WINDDIR,checkBoxWindDirection.isChecked());
        intent.putExtra(PRECIPITATION,switchPrecipitation.isChecked());

        startActivity(intent);
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
