package com.example.yelpclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
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