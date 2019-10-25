package com.example.borgerkong;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    private ArrayList<OrderItem> orderToPass;


    public void setData(ArrayList<OrderItem> ordersToPass) {
        this.orderToPass = ordersToPass;
    }

    @NonNull
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.order_item, parent, false);

        // Then create an instance of your custom ViewHolder with the View you got from inflating
        // the layout.
        OrderViewHolder orderViewHolder = new OrderViewHolder(view);
        return orderViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        // Compare what we have in this method, to what we used to have in MainActivity

        // 'position' is the index of the ViewHolder currently being bound (note VIEWHOLDER). So
        // if position is 0, then we are binding the first ViewHolder in the list. This means the
        // corresponding data object will be at index 0 of our data ArrayList.
        final OrderItem itemAtPosition = orderToPass.get(position);

            holder.itemName.setText(itemAtPosition.getOrderItemName());
            holder.itemPrice.setText("$" + String.format("%.2f", (itemAtPosition.getOrderItemPrice())));
            holder.itemImageView.setImageResource(itemAtPosition.getOrderItemImage());
            holder.itemQuantity.setText("Q: "+itemAtPosition.getOrderQuantity());

    }

    @Override
    public int getItemCount() {
        return orderToPass.size();
    }

    // ViewHolder represents one item, but doesn't have data when it's first constructed.
    // We assign the data in onBindViewHolder.
    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView itemName;
        public TextView itemPrice;
        public ImageView itemImageView;
        public TextView itemQuantity;


        // This constructor is used in onCreateViewHolder
        public OrderViewHolder(View v) {
            super(v);  // runs the constructor for the ViewHolder superclass
            view = v;
            itemName = v.findViewById(R.id.oItemName);
            itemPrice = v.findViewById(R.id.oItemPrice);
            itemImageView = v.findViewById(R.id.oItemPhoto);
            itemQuantity = v.findViewById(R.id.oQuantity);
        }
    }
}

