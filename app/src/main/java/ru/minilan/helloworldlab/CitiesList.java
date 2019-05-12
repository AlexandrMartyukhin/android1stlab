package ru.minilan.helloworldlab;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class CitiesList extends Fragment {

    private boolean isExistFragmentWeather;
    int currentPosition;
    private static final String KEY = "CurrentCity";

    View rootView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_list, container, false);
        Log.i(MainActivity.LOGTAG, "FragmentCitiesList onCreateView()...");
        return rootView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final RecyclerView recyclerView = rootView.findViewById(R.id.recyclerViewCities);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        CityListBuilder cityListBuilder = new CityListBuilder(getResources());
        final List<CityCard> cityCards = cityListBuilder.build();

        final CityListAdapter cityListAdapter = new CityListAdapter(cityCards);
        recyclerView.setAdapter(cityListAdapter);

        View detailsFrame = getActivity().findViewById(R.id.fragment);
        isExistFragmentWeather = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;
        if (savedInstanceState != null) {
            currentPosition = savedInstanceState.getInt(KEY, 0);
        } else {
            currentPosition = 0;
        }

        if (isExistFragmentWeather) {
            showWeather(currentPosition);
        }

        cityListAdapter.setOnItemClickListener(new CityListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                currentPosition = position;
                showWeather(position);
            }
        });


        Log.i(MainActivity.LOGTAG, "FragmentCitiesList onActivityCreated()...");
    }

    private void showWeather(int position) {
        if (isExistFragmentWeather) {

            FragmentWeather detail = (FragmentWeather) getFragmentManager().findFragmentById(R.id.fragment);

            if (detail == null || detail.getIndex() != position) {

                detail = FragmentWeather.create(position);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment, detail);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }

        } else {

            Intent intent = new Intent();
            intent.setClass(getActivity(), SecondActivity.class);
            intent.putExtra("index", position);
            startActivity(intent);
        }
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY, currentPosition);
        Log.i(MainActivity.LOGTAG, "FragmentCitiesList onSaveInstanceState()...");
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

    @Override
    public void onStart() {
        super.onStart();
        Log.i(MainActivity.LOGTAG, "FragmentCitiesList onStart()...");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(MainActivity.LOGTAG, "FragmentCitiesList onResume()...");

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(MainActivity.LOGTAG, "FragmentCitiesList onAttach()...");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(MainActivity.LOGTAG, "FragmentCitiesList onPause()...");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(MainActivity.LOGTAG, "FragmentCitiesList onStop()...");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(MainActivity.LOGTAG, "FragmentCitiesList onDestroyView()...");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(MainActivity.LOGTAG, "FragmentCitiesList onDestroy()...");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(MainActivity.LOGTAG, "FragmentCitiesList onDetach()...");

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(MainActivity.LOGTAG, "FragmentCitiesList onCreate()...");
    }


}
