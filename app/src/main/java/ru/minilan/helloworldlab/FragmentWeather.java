package ru.minilan.helloworldlab;


import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentWeather extends Fragment {

    public static FragmentWeather create(int index) {
        FragmentWeather fragmentWeather = new FragmentWeather();

        Bundle args = new Bundle();
        args.putInt("index", index);
        fragmentWeather.setArguments(args);
        return fragmentWeather;
    }

    public int getIndex() {
        int index = getArguments().getInt("index", 1);
        return index;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(MainActivity.LOGTAG, "FragmentWeather onCreate()...");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        TypedArray temps = getResources().obtainTypedArray(R.array.temperature_array);

        int temp = temps.getResourceId(getIndex(), -1);

        Log.i(MainActivity.LOGTAG, "TEMP = " + temp);

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_weather, container, false);
        TextView textViewHeaderTown = rootView.findViewById(R.id.textviewheadertown);
        TextView textViewTodayDay = rootView.findViewById(R.id.textViewTodayDay);
        TextView textViewTodayNight = rootView.findViewById(R.id.textViewTodayNight);
        TextView textViewTomorrowDay = rootView.findViewById(R.id.textViewTomorrowDay);
        TextView textViewTomorrowNight = rootView.findViewById(R.id.textViewTomorrowNight);

        String town;
//        if (((town = getIntent().getExtras().getString(MainActivity.TOWN)) == null) || (town.equals(""))) {
//            town = getResources().getString(R.string.def_town);
//            Toast toast = Toast.makeText(getApplicationContext(), getResources().getString(R.string.show_def_town),
//                    Toast.LENGTH_LONG);
//            toast.setGravity(Gravity.CENTER,0,0);
//            toast.show();
//        }

        // STAB !!! SET TOWN
        town = getResources().getString(R.string.def_town);


        String header = getResources().getText(R.string.app_header_in_town_X) + " " + town;
        textViewHeaderTown.setText(header);

        //stabs
        textViewTodayDay.setText("10");
        textViewTodayNight.setText("5");
        textViewTomorrowDay.setText("12");
        textViewTomorrowNight.setText("6");

//        Log.i(MainActivity.LOGTAG, "  Show Pressure - " + String.valueOf(getIntent().getExtras().getBoolean(MainActivity.PRESSURE)));
//        Log.i(MainActivity.LOGTAG, "  Show Humidity - " + String.valueOf(getIntent().getExtras().getBoolean(MainActivity.HUMIDITY)));
//        Log.i(MainActivity.LOGTAG, "  Show WindSpeed - " + String.valueOf(getIntent().getExtras().getBoolean(MainActivity.WINDSPEED)));
//        Log.i(MainActivity.LOGTAG, "  Show WindDirection - " + String.valueOf(getIntent().getExtras().getBoolean(MainActivity.WINDDIR)));
//        Log.i(MainActivity.LOGTAG, "  Show Precipitation - " + String.valueOf(getIntent().getExtras().getBoolean(MainActivity.PRECIPITATION)));

        Log.i(MainActivity.LOGTAG, "FragmentWeather onCreateView()...");
        return rootView;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(MainActivity.LOGTAG, "FragmentWeather onAttach()...");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(MainActivity.LOGTAG, "FragmentWeather onActivityCreated()...");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(MainActivity.LOGTAG, "FragmentWeather onStart()...");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(MainActivity.LOGTAG, "FragmentWeather onResume()...");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(MainActivity.LOGTAG, "FragmentWeather onPause()...");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(MainActivity.LOGTAG, "FragmentWeather onStop()...");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(MainActivity.LOGTAG, "FragmentWeather onDestroyView()...");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(MainActivity.LOGTAG, "FragmentWeather onDestroy()...");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(MainActivity.LOGTAG, "FragmentWeather onDetach()...");

    }
}
