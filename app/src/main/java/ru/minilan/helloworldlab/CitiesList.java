package ru.minilan.helloworldlab;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CitiesList extends ListFragment {

    private boolean isExistFragmentWeather;
    int currentPosition;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(MainActivity.LOGTAG, "FragmentCitiesList onCreate()...");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(MainActivity.LOGTAG, "FragmentCitiesList onCreateView()...");
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(MainActivity.LOGTAG, "FragmentCitiesList onAttach()...");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.Cities,
                android.R.layout.simple_list_item_activated_1);
        setListAdapter(arrayAdapter);


        View detailsFrame = getActivity().findViewById(R.id.fragment);
        isExistFragmentWeather = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;
        if (savedInstanceState != null) {
            currentPosition = savedInstanceState.getInt("city", 0);
        } else {
            currentPosition = 0;
        }

        if (isExistFragmentWeather) {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showWeather(currentPosition);
        }

        Log.i(MainActivity.LOGTAG, "FragmentCitiesList onActivityCreated()...");
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        //Log.i(MainActivity.LOGTAG, "KEY PRESSED");
        currentPosition = position;
        showWeather(position);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("city", currentPosition);
        Log.i(MainActivity.LOGTAG, "FragmentCitiesList onSaveInstanceState()...");
    }

    @Override
    public void onStart() {
        super.onStart();
        getListView().setItemChecked(currentPosition, true);
        Log.i(MainActivity.LOGTAG, "FragmentCitiesList onStart()...");

    }

    @Override
    public void onResume() {
        super.onResume();

        Log.i(MainActivity.LOGTAG, "FragmentCitiesList onResume()...");

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

    private void showWeather(int position) {
        if (isExistFragmentWeather) {
            getListView().setItemChecked(position, true);

            FragmentWeather detail = (FragmentWeather) getFragmentManager().findFragmentById(R.id.fragment);

            if (detail == null || detail.getIndex() != position) {

                detail = FragmentWeather.create(position);
// Выполняем транзакцию по замене фрагмента
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment, detail);  // замена фрагмента
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }

        }
        else {

            Intent intent = new Intent();
            intent.setClass(getActivity(), SecondActivity.class);
            intent.putExtra("index", position);
            startActivity(intent);
        }
    }


}
