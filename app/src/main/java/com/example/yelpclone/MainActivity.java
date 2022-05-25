package com.example.yelpclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.yelpclone.adapters.RestaurantAdapter;
import com.example.yelpclone.models.DataModel;
import com.example.yelpclone.services.RetrofitClient;
import com.example.yelpclone.services.YelpService;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private static final String API_KEY = "4uk-dc5mn2fGHSBc4e2zP3XzecusW01JMifJ_AWR0R1O8wQhsmu7B5zRnxcT-SFpXM2tDyuxtdRtBnoFm0xDurroZr9edbKMAy4c-IizK8oKF75bonisjG69tGNuYnYx";
    private static final String TAG = "MainActivity";

    RecyclerView recyclerView;
    RestaurantAdapter restaurantAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        restaurantAdapter = new RestaurantAdapter();

        YelpService yelpService = RetrofitClient.getRetrofitInstance().create(YelpService.class);
        Call<DataModel> call = yelpService.searchRestaurants("Bearer " + API_KEY, "Avocado", "New York");
        call.enqueue(new Callback<DataModel>() {

            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                if(response.isSuccessful()){
                    recyclerView.setAdapter(restaurantAdapter);
                    restaurantAdapter.setData(response.body());
                }
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
                Log.e("failure",t.getLocalizedMessage());
            }
        });
    }
}