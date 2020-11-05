package com.example.restaurantapp.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantapp.R;
import com.example.restaurantapp.model.City;
import com.example.restaurantapp.model.Collection;
import com.example.restaurantapp.model.SingleCollection;

import java.util.List;

public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.MyViewHolder>{
    private List<SingleCollection> collectionList;



    public CollectionAdapter(List<SingleCollection> collectionList) {
        this.collectionList = collectionList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.collection_item, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SingleCollection collection = collectionList.get(position);
        holder.title.setText(collection.getTitle());
        holder.id.setText(collection.getId());
        holder.url.setText(collection.getUrl());
        holder.description.setText(collection.getDescription());

    }

    @Override
    public int getItemCount() {
        return collectionList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView id, title, url, description;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            id = (TextView) view.findViewById(R.id.id);
            url= (TextView) view.findViewById(R.id.url);
            description = (TextView) view.findViewById(R.id.description);
        }
    }

}
