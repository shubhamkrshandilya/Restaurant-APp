package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.restaurantapp.api.ApiClient;
import com.example.restaurantapp.api.ApiInterface;
import com.example.restaurantapp.model.City;
import com.example.restaurantapp.model.Collection;
import com.example.restaurantapp.model.Collections;
import com.example.restaurantapp.model.Suggetion;
import com.example.restaurantapp.view.CityAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = ".MainActivity";
    Button button, button2;
    private static final String API_KEY = "f20e88705c77e8d75bc6842975d85c54";
    private List<City> citiesList;
    private List<Collection> collectionList;
    private RecyclerView recyclerView;
    private CityAdapter mAdapter;
    private EditText searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
//        button2 = findViewById(R.id.button2);
        citiesList = new ArrayList<>();
        collectionList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        searchBar = findViewById(R.id.searchBar);

//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                for(City city: citiesList) {
//                    Log.d(TAG, "onClick: "+city.getName());
//                }
////                for(Collection collection: collectionList) {
////                    Log.d(TAG, "onClick: "+collection.getSingleCollection().getTitle());
////                }
//            }
//        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
//                Call<Collections> call = apiService.getCollections(1, API_KEY);
//                call.enqueue(new Callback<Collections>() {
//                    @Override
//                    public void onResponse(Call<Collections> call, Response<Collections> response) {
//                        Log.d(TAG, "onResponse: "+ response.body());
//                        collectionList = response.body().getCollections();
//                    }
//
//                    @Override
//                    public void onFailure(Call<Collections> call, Throwable t) {
//                        Log.d(TAG, "onResponse: "+ "failed");
//                    }
//                });
                String searchKey = searchBar.getText().toString();
                ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
                Call<Suggetion> call = apiService.getCities(searchKey, API_KEY);
                call.enqueue(new Callback<Suggetion>() {
                    @Override
                    public void onResponse(Call<Suggetion> call, Response<Suggetion> response) {
                        Log.d(TAG, "onResponse: "+ response.body());
                        citiesList = response.body().getCity();
                        mAdapter = new CityAdapter(getApplicationContext(), citiesList);

                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        recyclerView.setLayoutManager(mLayoutManager);
                        recyclerView.setItemAnimator(new DefaultItemAnimator());
                        recyclerView.setAdapter(mAdapter);
                    }

                    @Override
                    public void onFailure(Call<Suggetion> call, Throwable t) {
                        Log.d(TAG, "onResponse: "+ "failed");
                    }
                });
             }
            });
        }
}