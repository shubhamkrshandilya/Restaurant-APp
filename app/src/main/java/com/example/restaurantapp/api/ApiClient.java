package com.example.restaurantapp.api;

/**
 * Created by Neel Patel on 10/12/2017.
 */
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {

    public static final String BASE_URL = "https://developers.zomato.com/api/v2.1/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .client(providesHttpClient())
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static OkHttpClient providesHttpClient() {
        return new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .addInterceptor(providesHttpLoggingInterceptor())
                .build();
    }

    public static HttpLoggingInterceptor providesHttpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }
}