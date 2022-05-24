package com.example.yelpclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.yelpclone.models.DataModel;
import com.example.yelpclone.services.RetrofitClient;
import com.example.yelpclone.services.YelpService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private static final String API_KEY = "4uk-dc5mn2fGHSBc4e2zP3XzecusW01JMifJ_AWR0R1O8wQhsmu7B5zRnxcT-SFpXM2tDyuxtdRtBnoFm0xDurroZr9edbKMAy4c-IizK8oKF75bonisjG69tGNuYnYx";
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Build Recycler View here + Make new class for Mapping data WATCH: https://www.youtube.com/watch?v=de8F4jwTbE8

                YelpService yelpService = RetrofitClient.getRetrofitInstance().create(YelpService.class);
                Call<DataModel> call = yelpService.searchRestaurants("Bearer "+API_KEY, "Avocado", "New York");
                call.enqueue(new Callback<DataModel>() {
                    @Override
                    public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                        Log.e(TAG, "onResponse: " +response.body());

                    }

                    @Override
                    public void onFailure(Call<DataModel> call, Throwable t) {
                        Log.e(TAG, "onFailure: "+t.getMessage());
                    }
                });


    }
}