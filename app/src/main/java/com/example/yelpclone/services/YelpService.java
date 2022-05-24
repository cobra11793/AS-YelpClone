package com.example.yelpclone.services;

import com.example.yelpclone.models.DataModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface YelpService {
    String JSON_DATA_LINK = "businesses/search";
    @GET(JSON_DATA_LINK)
    Call<DataModel> searchRestaurants(
            @Header("Authorization") String authHeader,
            @Query("term") String term,
            @Query("location") String location
    );

}
