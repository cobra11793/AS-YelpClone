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
        String address = dataModel.yelpRestaurants.get(position).yelpLocations.getAddress();
        String category = dataModel.yelpRestaurants.get(position).yelpCategories.get(0).getTitle();
        double distanceInMeters = dataModel.yelpRestaurants.get(position).getDistanceInMeters();
        String price = dataModel.yelpRestaurants.get(position).getPrice();
        holder.name.setText(name);
        holder.ratingBar.setRating((float) rating);
        holder.numReviews.setText(numReviews);
        holder.address.setText(address);
        holder.category.setText(category);
        holder.distanceInMeters.setText((int) distanceInMeters);
        holder.price.setText(price);
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
        TextView category;
        TextView distanceInMeters;
        TextView price;

        public RestaurantAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            numReviews = itemView.findViewById(R.id.tvNumReviews);
            address = itemView.findViewById(R.id.tvAddress);
            category = itemView.findViewById(R.id.tvCategory);
            distanceInMeters = itemView.findViewById(R.id.tvDistance);
            price = itemView.findViewById(R.id.tvPrice);
        }
    }
    }

