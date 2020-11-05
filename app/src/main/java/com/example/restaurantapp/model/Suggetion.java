package com.example.restaurantapp.model;

import com.example.restaurantapp.model.City;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Suggetion {
    @SerializedName("location_suggestions")
    @Expose
    private List<City> city;

    public List<City> getCity() {
        return city;
    }

    public void setCity(List<City> city) {
        this.city = city;
    }
}
