package com.nancy.mvpapplication;


import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nancy.mvpapplication.Pojo.CryptoData;
import com.nancy.mvpapplication.Pojo.StarWars;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
   // private List<CryptoData> data;
   private List<StarWars.People> data;
    private RecyclerViewAdapter.ClickListener clickListener;

    @Inject
    public RecyclerViewAdapter(ClickListener clickListener) {
        this.clickListener = clickListener;
        data = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_list_row, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        holder.txtCoin.setText(data.get(position).symbol);
//        holder.txtCurrentPrice.setText(data.get(position).priceUsd);
//        holder.txt1HourChange.setText(data.get(position).percentChange1h + "%");
//        holder.txt24HourChange.setText(data.get(position).percentChange24h + "%");
//        holder.txt7DayChange.setText(data.get(position).percentChange7d + "%");

        holder.txtCoin.setText(data.get(position).name);
        holder.txtCurrentPrice.setText(data.get(position).birthYear);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtCoin;
        private TextView txtCurrentPrice;
        private TextView txt1HourChange;
        private TextView txt24HourChange;
        private TextView txt7DayChange;
        private ConstraintLayout constraintLayoutContainer;

        ViewHolder(View itemView) {
            super(itemView);

            txtCoin = itemView.findViewById(R.id.txtCoin);
            txtCurrentPrice = itemView.findViewById(R.id.txtCurrentPrice);
            txt1HourChange = itemView.findViewById(R.id.txtOneHourChange);
            txt24HourChange = itemView.findViewById(R.id.txt24HourChange);
            txt7DayChange = itemView.findViewById(R.id.txt7DayChange);
            constraintLayoutContainer = itemView.findViewById(R.id.constraintLayout);

            constraintLayoutContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.launchIntent(data.get(getAdapterPosition()).name);
                }
            });
        }
    }

    public interface ClickListener {
        void launchIntent(String name);
    }

//    public void setData(List<CryptoData> data) {
//        this.data.addAll(data);
//        notifyDataSetChanged();
//    }

    public void setData(List<StarWars.People> data)
    {
        this.data.addAll(data);
        notifyDataSetChanged();

    }
}



