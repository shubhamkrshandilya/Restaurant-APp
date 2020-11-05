package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.restaurantapp.api.ApiClient;
import com.example.restaurantapp.api.ApiInterface;
import com.example.restaurantapp.model.Collection;
import com.example.restaurantapp.model.Collections;
import com.example.restaurantapp.model.SingleCollection;
import com.example.restaurantapp.view.CityAdapter;
import com.example.restaurantapp.view.CollectionAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CollectionActivity extends AppCompatActivity {

    private static final String API_KEY = "f20e88705c77e8d75bc6842975d85c54";
    private RecyclerView recyclerView;
    private CollectionAdapter mAdapter;
    private List<Collection> collectionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        collectionList = new ArrayList<>();
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        if (id != null) {
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Call<Collections> call = apiService.getCollections(Integer.parseInt(id), API_KEY);
            call.enqueue(new Callback<Collections>() {
                @Override
                public void onResponse(Call<Collections> call, Response<Collections> response) {
//                        Log.d(TAG, "onResponse: "+ response.body());
                    collectionList = response.body().getCollections();
                    List<SingleCollection> sLists = new ArrayList<>();
                    for (Collection s : collectionList) {
                        sLists.add(s.getSingleCollection());
                    }
                    mAdapter = new CollectionAdapter(sLists);

                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(mAdapter);
                }

                @Override
                public void onFailure(Call<Collections> call, Throwable t) {
//                        Log.d(TAG, "onResponse: "+ "failed");
                }
            });


        }
    }
}