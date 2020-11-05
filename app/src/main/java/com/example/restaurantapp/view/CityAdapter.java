package com.example.restaurantapp.view;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantapp.CollectionActivity;
import com.example.restaurantapp.R;
import com.example.restaurantapp.model.City;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.MyViewHolder>{
    private List<City> citiesList;
    private Context context;


    public CityAdapter(Context context, List<City> citiesList) {
        this.citiesList = citiesList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.city_item, parent, false);
        final MyViewHolder myViewHolder = new MyViewHolder(itemView);

        //Item Clicks
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final TextView textViewId = (TextView) itemView.findViewWithTag("id"); ;
                final String id = textViewId.getText().toString();
                Log.d("dbhhdhfbh", "onClick: "+ id);
                Intent intent = new Intent(context, CollectionActivity.class);
                intent.putExtra("id", id);
                context.startActivity(intent);

            }
        });

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        City city = citiesList.get(position);
        holder.title.setText(city.getName());
        holder.id.setText(city.getId());
        holder.countryId.setText(city.getCountry_id());
        holder.countryName.setText(city.getCountry_name());

    }

    @Override
    public int getItemCount() {
        return citiesList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView id, title, countryName, countryId;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            id = (TextView) view.findViewById(R.id.id);
            countryId = (TextView) view.findViewById(R.id.countryId);
            countryName = (TextView) view.findViewById(R.id.countryName);

        }
    }

}
