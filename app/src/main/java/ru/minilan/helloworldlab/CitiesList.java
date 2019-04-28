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
import android.widget.ListAdapter;
import android.widget.ListView;

public class CitiesList extends ListFragment {

    private boolean isExistFragmentWeather;
    int currentPosition = 0;

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

        View detailsFrame = getActivity().findViewById(R.id.weatherfragment);
        isExistFragmentWeather = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;
        if (savedInstanceState != null) {
            currentPosition = savedInstanceState.getInt("CurrentCity", 0);
        }
        if (isExistFragmentWeather) {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showWeather();
        }

        Log.i(MainActivity.LOGTAG, "FragmentCitiesList onActivityCreated()...");
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        currentPosition = position;
        showWeather();

        String selectedTown = getListView().getItemAtPosition(position).toString();
        Log.i(MainActivity.LOGTAG, "Selected town - " + selectedTown);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("CurrentCity", currentPosition);
        Log.i(MainActivity.LOGTAG, "FragmentCitiesList onSaveInstanceState()...");
    }

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

    private void showWeather() {
        if (isExistFragmentWeather) {
            getListView().setItemChecked(currentPosition, true);

            FragmentWeather detail = (FragmentWeather) getFragmentManager().findFragmentById(R.id.weatherfragment);

            if (detail == null || detail.getIndex() != currentPosition) {
                detail = FragmentWeather.create(currentPosition);

// Выполняем транзакцию по замене фрагмента
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.weatherfragment, detail);  // замена фрагмента
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }

        }
        else {
// Если нельзя вывести герб рядом, откроем вторую activity
            Intent intent = new Intent();
            intent.setClass(getActivity(), SecondActivity.class);
// и передадим туда параметры
            intent.putExtra("index", currentPosition);
            startActivity(intent);
        }
    }


}
