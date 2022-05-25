package com.example.yelpclone.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yelpclone.R;
import com.example.yelpclone.models.DataModel;

import org.w3c.dom.Text;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantAdapterViewHolder> {

    private List<DataModel> dataModelList;
    private Context context;

    public RestaurantAdapter() {
    }
    public void setData(List<DataModel> dataModelList) {
        this.dataModelList = dataModelList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RestaurantAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new RestaurantAdapter.RestaurantAdapterViewHolder(LayoutInflater.from(context).inflate(R.layout.item_restaurant,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantAdapterViewHolder holder, int position) {
        DataModel dataModel = dataModelList.get(position);
        String name = dataModel.yelpRestaurants.get(position).getName();
        double rating = dataModel.yelpRestaurants.get(position).getRating();
        int numReviews = dataModel.yelpRestaurants.get(position).getNumReviews();
        holder.name.setText(name);
        holder.ratingBar.setRating((float) rating);
        holder.numReviews.setText(numReviews);
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public class RestaurantAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        RatingBar ratingBar;
        TextView numReviews;
        TextView address;

        public RestaurantAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            numReviews = itemView.findViewById(R.id.tvNumReviews);
            address = itemView.findViewById(R.id.tvAddress);
        }
    }
    }

