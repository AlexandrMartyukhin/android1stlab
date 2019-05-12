package ru.minilan.helloworldlab;

import android.content.res.Resources;
import android.content.res.TypedArray;

import java.util.ArrayList;
import java.util.List;

public class CityListBuilder {

    private final List<CityCard> dataSource;
    private final Resources resources;

    public CityListBuilder(Resources resources) {
        dataSource = new ArrayList<>();
        this.resources = resources;
    }

    public List<CityCard> build() {
        String[] cities = resources.getStringArray(R.array.Cities);
        int[] cities_pics = getImageArray();

        for ( int i = 0; i < cities.length; i++){
            dataSource.add(new CityCard(cities[i],cities_pics[i]));
        }

        return dataSource;
    }


    private int[] getImageArray() {

        TypedArray pics = resources.obtainTypedArray(R.array.cities_pics);
        int length = pics.length();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = pics.getResourceId(i, 0);
        }
        pics.recycle();
        return array;
    }
}
