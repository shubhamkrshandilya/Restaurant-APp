package com.example.restaurantapp.api;

import com.example.restaurantapp.model.Collections;
import com.example.restaurantapp.model.Suggetion;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by Neel Patel on 10/12/2017.
 */

public interface ApiInterface {



    @GET("collections")
    Call<Collections> getCollections(@Query("city_id") Integer city_id, @Header("user-key") String apiKey);

    @GET("cities")
    Call<Suggetion> getCities(@Query("q") String cityName, @Header("user-key") String apiKey);


}
