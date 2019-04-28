package ru.minilan.helloworldlab;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentWeather extends Fragment {

    public static FragmentWeather create(int index) {
        FragmentWeather fragmentWeather = new FragmentWeather();

        Bundle args = new Bundle();
        args.putInt("index", index);
        fragmentWeather.setArguments(args);
        return fragmentWeather;
    }

    public int getIndex() {
        int index;
        try {
            index = getArguments().getInt("index");
        } catch (NullPointerException e) {
            index = 0;
        }
        return index;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(MainActivity.LOGTAG, "FragmentWeather onCreate()...");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_weather, container, false);
        int[] temps = getResources().getIntArray(R.array.temperature_array);
        String[] cities = getResources().getStringArray(R.array.Cities);

        int temp = temps[getIndex()];
        TextView textViewHeaderTown = rootView.findViewById(R.id.textviewheadertown);
        TextView textViewTodayDay = rootView.findViewById(R.id.textViewTodayDay);
        TextView textViewTodayNight = rootView.findViewById(R.id.textViewTodayNight);
        TextView textViewTomorrowDay = rootView.findViewById(R.id.textViewTomorrowDay);
        TextView textViewTomorrowNight = rootView.findViewById(R.id.textViewTomorrowNight);

        String town;
        town = cities[getIndex()];


        String header = getResources().getText(R.string.app_header_in_town_X) + " " + town;
        textViewHeaderTown.setText(header);

        //stabs
        textViewTodayDay.setText(String.valueOf(temp));
        textViewTodayNight.setText(String.valueOf(temp));
        textViewTomorrowDay.setText(String.valueOf(temp));
        textViewTomorrowNight.setText(String.valueOf(temp));

        Log.i(MainActivity.LOGTAG, "FragmentWeather onCreateView()...");
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(MainActivity.LOGTAG, "FragmentWeather onSaveInstanceState()...");
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
