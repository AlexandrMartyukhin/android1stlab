package ru.minilan.helloworldlab;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    private final List<WeatherCard> dataSource;


    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textViewCardMorningTemp, textViewCardDayTemp,
                textViewCardEveningTemp, textViewCardNightTemp, textViewCardPressureData,
                textViewCardHumidityData, textViewCardDate;

        public ViewHolder(View view) {
            super(view);

            textViewCardDate = view.findViewById(R.id.textViewCardDate);
            textViewCardMorningTemp = view.findViewById(R.id.textViewCardMorningTemp);
            textViewCardDayTemp = view.findViewById(R.id.textViewCardDayTemp);
            textViewCardEveningTemp = view.findViewById(R.id.textViewCardEveningTemp);
            textViewCardNightTemp = view.findViewById(R.id.textViewCardNightTemp);
            textViewCardPressureData = view.findViewById(R.id.textViewCardPressureData);
            textViewCardHumidityData = view.findViewById(R.id.textViewCardHumidityData);
        }
    }

    public RVAdapter(List<WeatherCard> dataSource) {
        this.dataSource = dataSource;

    }

    @NonNull
    @Override
    public RVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        WeatherCard weatherCard = dataSource.get(position);

        viewHolder.textViewCardDate.setText(weatherCard.getDate());
        viewHolder.textViewCardMorningTemp.setText(weatherCard.getTempMorning());
        viewHolder.textViewCardDayTemp.setText(weatherCard.getTempDay());
        viewHolder.textViewCardEveningTemp.setText(weatherCard.getTempEvening());
        viewHolder.textViewCardNightTemp.setText(weatherCard.getTempNight());
        viewHolder.textViewCardPressureData.setText(weatherCard.getPressure());
        viewHolder.textViewCardHumidityData.setText(weatherCard.getHumidity());

    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

}
