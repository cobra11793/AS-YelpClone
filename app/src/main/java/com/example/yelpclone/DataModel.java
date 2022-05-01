package com.example.yelpclone;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DataModel{

    @SerializedName("total")
    public int total;
    @SerializedName("businesses")
    public ArrayList<YelpRestaurants> yelpRestaurants;

    public void setTotal(int total) {
        this.total = total;
    }

    public void setYelpRestaurants(ArrayList<YelpRestaurants> yelpRestaurants) {
        this.yelpRestaurants = yelpRestaurants;
    }

    public int getTotal() {
        return total;
    }

    public ArrayList<YelpRestaurants> getYelpRestaurants() {
        return yelpRestaurants;
    }

    class YelpRestaurants{
        @SerializedName("name")
        public String name;
        @SerializedName("rating")
        public double rating;
        @SerializedName("price")
        public String price;
        @SerializedName("review_count")
        public int numReviews;
        @SerializedName("distance")
        public double distanceInMeters;
        @SerializedName("image_url")
        public String imageUrl;
        @SerializedName("categories")
        public ArrayList<YelpCategories> yelpCategories;
        @SerializedName("location")
        public ArrayList<YelpLocations> yelpLocations;

        public void setName(String name) {
            this.name = name;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public void setNumReviews(int numReviews) {
            this.numReviews = numReviews;
        }

        public void setDistanceInMeters(double distanceInMeters) {
            this.distanceInMeters = distanceInMeters;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public void setYelpCategories(ArrayList<YelpCategories> yelpCategories) {
            this.yelpCategories = yelpCategories;
        }

        public void setYelpLocations(ArrayList<YelpLocations> yelpLocations) {
            this.yelpLocations = yelpLocations;
        }

        public String getName() {
            return name;
        }

        public double getRating() {
            return rating;
        }

        public String getPrice() {
            return price;
        }

        public int getNumReviews() {
            return numReviews;
        }

        public double getDistanceInMeters() {
            return distanceInMeters;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public ArrayList<YelpCategories> getYelpCategories() {
            return yelpCategories;
        }

        public ArrayList<YelpLocations> getYelpLocations() {
            return yelpLocations;
        }
    }

    class YelpCategories{
        @SerializedName("title")
        public String title;

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

    class YelpLocations{
        @SerializedName("address")
        public String address;

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAddress() {
            return address;
        }
    }
}
