package com.example.borgerkong;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private ArrayList<Item> itemsToAdapt;

    public void setData(ArrayList<Item> itemsToAdapt) {
        this.itemsToAdapt = itemsToAdapt;
    }

    @NonNull
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item, parent, false);

        // Then create an instance of your custom ViewHolder with the View you got from inflating
        // the layout.
        ItemViewHolder ItemViewHolder = new ItemViewHolder(view);
        return ItemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        // Compare what we have in this method, to what we used to have in MainActivity

        // 'position' is the index of the ViewHolder currently being bound (note VIEWHOLDER). So
        // if position is 0, then we are binding the first ViewHolder in the list. This means the
        // corresponding data object will be at index 0 of our data ArrayList.
        final Item itemAtPosition = itemsToAdapt.get(position);

        holder.itemName.setText(itemAtPosition.getItemName());
        holder.itemPrice.setText("$"+ String.format("%.2f",itemAtPosition.getItemPrice()));


        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();

                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("ItemID", itemAtPosition.getItemID());
                context.startActivity(intent);
            }
        });


        holder.itemImageView.setImageResource(itemAtPosition.getDrawableID());
    }

    @Override
    public int getItemCount() {
        return itemsToAdapt.size();
    }

    // ViewHolder represents one item, but doesn't have data when it's first constructed.
    // We assign the data in onBindViewHolder.
    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView itemName;
        public TextView itemPrice;
        public ImageView itemImageView;

        // This constructor is used in onCreateViewHolder
        public ItemViewHolder(View v) {
            super(v);  // runs the constructor for the ViewHolder superclass
            view = v;
            itemName = v.findViewById(R.id.itemName);
            itemPrice = v.findViewById(R.id.itemPrice);
            itemImageView = v.findViewById(R.id.itemPhoto);
        }
    }
}

