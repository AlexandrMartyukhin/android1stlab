package ru.minilan.helloworldlab;


import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class FragmentWeather extends Fragment {

    TextView textViewTodayDay, textViewTodayNight, textViewTomorrowDay, textViewTomorrowNight,
            textViewTodayPressure, textViewTomorrowPressure, textViewTodayHumidity, textViewTomorrowHumidity;
    View rootView;

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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_resview_weather, container, false);

        // set Town in header textview
        setTown(getTown(getIndex()));

        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        DataSourceBuilder dataSourceBuilder = new DataSourceBuilder(getResources());
        final List<WeatherCard> dataSource = dataSourceBuilder.build();

        final RVAdapter rvAdapter = new RVAdapter(dataSource);
        recyclerView.setAdapter(rvAdapter);

        //
        Button buttonMore = rootView.findViewById(R.id.buttonAddMoreDays);
        buttonMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSource.add(new WeatherCard("10", "15", "12", "12", "757mm", "70%","27 april 2019"));
                dataSource.add(new WeatherCard("10", "15", "12", "12", "757mm", "70%","28 april 2019"));

                rvAdapter.notifyDataSetChanged();
            }
        });
        Log.i(MainActivity.LOGTAG, "FragmentWeather onCreateView()...");
        return rootView;
    }


    @NonNull
    private String getTown(int index) {
        String[] cities = getResources().getStringArray(R.array.Cities);
        return getString(R.string.app_header_in_town_X, cities[index]);
    }

    private void setTown(String town) {
        ((TextView) rootView.findViewById(R.id.textviewheadertown)).setText(town);
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


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(MainActivity.LOGTAG, "FragmentWeather onCreate()...");
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

    private void getDataDetails(int index) {

        //get arrays
        int[] temps = getResources().getIntArray(R.array.temperature_array);
        int[] pressures = getResources().getIntArray(R.array.pressure_array);
        int[] hums = getResources().getIntArray(R.array.humidity_array);
        String[] cities = getResources().getStringArray(R.array.Cities);
        TypedArray overcastPics = getResources().obtainTypedArray(R.array.overcast_pics_array);

        int temp = temps[index];
        int pressure = pressures[index];
        int hum = hums[index];

        Random random = new Random();
        int random_index = random.nextInt(3);

        String header;
        header = getString(R.string.app_header_in_town_X, cities[index]);

        textViewTodayDay = rootView.findViewById(R.id.textViewTodayDay);
        textViewTodayNight = rootView.findViewById(R.id.textViewTodayNight);
        textViewTomorrowDay = rootView.findViewById(R.id.textViewTomorrowDay);
        textViewTomorrowNight = rootView.findViewById(R.id.textViewTomorrowNight);
        textViewTodayPressure = rootView.findViewById(R.id.textViewTodayPressure);
        textViewTomorrowPressure = rootView.findViewById(R.id.textViewTomorrowPressure);
        textViewTodayHumidity = rootView.findViewById(R.id.textViewTodayHumidity);
        textViewTomorrowHumidity = rootView.findViewById(R.id.textViewTomorrowHumidity);

        //stabs
        ((TextView) rootView.findViewById(R.id.textviewheadertown)).setText(header);
        textViewTodayDay.setText(String.valueOf(temp));
        textViewTodayNight.setText(String.valueOf(temp - 2));
        textViewTomorrowDay.setText(String.valueOf(temp + 2));
        textViewTomorrowNight.setText(String.valueOf(temp));
        textViewTodayPressure.setText(String.valueOf(pressures[random_index]));
        textViewTomorrowPressure.setText(String.valueOf(pressure));
        textViewTodayHumidity.setText(hum + "%");
        textViewTomorrowHumidity.setText(hum + "%");
        ImageView imageViewTodayOvercast = rootView.findViewById(R.id.imageViewOvercastToday);
        ImageView imageViewOvercastTomorrow = rootView.findViewById(R.id.imageViewOvercastTomorrow);

        imageViewTodayOvercast.setImageResource(R.drawable.halfsun32);
        imageViewOvercastTomorrow.setImageResource(overcastPics.getResourceId(random_index, 0));

    }

}
