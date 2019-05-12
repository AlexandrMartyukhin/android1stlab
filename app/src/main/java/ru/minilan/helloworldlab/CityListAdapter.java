package ru.minilan.helloworldlab;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CityListAdapter extends RecyclerView.Adapter<CityListAdapter.ViewHolder> {
    private final List<CityCard> dataSource;
    private OnItemClickListener itemClickListener;

    public CityListAdapter(List<CityCard> dataSource) {
        this.dataSource = dataSource;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView textViewCityCard;
        private final ImageView imageViewCardTown;

        public ViewHolder(final View view){
            super(view);

            textViewCityCard = view.findViewById(R.id.textViewCityCard);
            imageViewCardTown = view.findViewById(R.id.imageViewCardTown);

            imageViewCardTown.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemClickListener != null)
                        itemClickListener.onItemClick(view,getAdapterPosition());

                }
            });

        }
    }



    @NonNull
    @Override
    public CityListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_city_card,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        CityCard cityCard = dataSource.get(position);
        viewHolder.textViewCityCard.setText(cityCard.getCity());
        viewHolder.imageViewCardTown.setImageResource(cityCard.getCityPic());
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

}
