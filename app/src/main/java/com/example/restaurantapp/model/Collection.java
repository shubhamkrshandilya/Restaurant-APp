package com.example.restaurantapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Collection {
    @SerializedName("collection")
    @Expose
    private SingleCollection singleCollection;

    public SingleCollection getSingleCollection() {
        return singleCollection;
    }

    public void setSingleCollection(SingleCollection singleCollection) {
        this.singleCollection = singleCollection;
    }
}


