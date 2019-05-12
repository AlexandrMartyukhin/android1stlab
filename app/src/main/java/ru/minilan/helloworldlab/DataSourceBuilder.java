package ru.minilan.helloworldlab;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

public class DataSourceBuilder {

    private final List<WeatherCard> dataSource;
    private final Resources resources;

    public DataSourceBuilder(Resources resources) {
        dataSource = new ArrayList<>(7);
        this.resources = resources;
    }

    public List<WeatherCard> build() {


        //STUBS
        dataSource.add(new WeatherCard("12", "12", "11", "10", "750 mm rt st", "40 %","20 april 2019"));
        dataSource.add(new WeatherCard("14", "15", "12", "12", "757 mm rt st", "70 %","21 april 2019"));
        dataSource.add(new WeatherCard("12", "12", "11", "10", "750 mm rt st", "40 %","22 april 2019"));
        dataSource.add(new WeatherCard("14", "15", "12", "12", "757 mm rt st", "70 %","23 april 2019"));
        dataSource.add(new WeatherCard("12", "12", "11", "10", "750 mm rt st", "40 %","24 april 2019"));
        dataSource.add(new WeatherCard("14", "15", "12", "12", "757 mm rt st", "70 %","25 april 2019"));
        dataSource.add(new WeatherCard("12", "12", "11", "10", "750 mm rt st", "40 %","26 april 2019"));

        return dataSource;
    }
}
