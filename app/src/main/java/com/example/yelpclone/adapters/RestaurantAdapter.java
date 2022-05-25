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

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantAdapterViewHolder> {
    private DataModel dataModel;
    private Context context;

    public RestaurantAdapter() {
    }

    public void setData(DataModel dataModelList) {
        this.dataModel = dataModelList;
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
        DataModel.YelpRestaurants restaurants = dataModel.yelpRestaurants.get(position);
        holder.nameTextView.setText(restaurants.name);
        holder.ratingBar.setRating((float) restaurants.rating);
//        holder.numReviewsTextView.setText(restaurants.numReviews);
//        holder.addressTextView.setText(restaurants.yelpLocations.address);
//        holder.categoryTextView.setText(restaurants.yelpCategories);
//        holder.distanceInMetersTextView.setText((int) distanceInMeters);
//        holder.priceTextView.setText(price);
    }

    @Override
    public int getItemCount() {
        return dataModel.yelpRestaurants.size();
    }

    public class RestaurantAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        RatingBar ratingBar;
        TextView numReviewsTextView;
        TextView addressTextView;
        TextView categoryTextView;
        TextView distanceInMetersTextView;
        TextView priceTextView;

        public RestaurantAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.tvName);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            numReviewsTextView = itemView.findViewById(R.id.tvNumReviews);
            addressTextView = itemView.findViewById(R.id.tvAddress);
            categoryTextView = itemView.findViewById(R.id.tvCategory);
            distanceInMetersTextView = itemView.findViewById(R.id.tvDistance);
            priceTextView = itemView.findViewById(R.id.tvPrice);
        }
    }
    }

