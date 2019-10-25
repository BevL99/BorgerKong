package com.example.borgerkong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.borgerkong.MainActivity.orderList;
import static com.example.borgerkong.MainActivity.orders;


public class DetailActivity extends AppCompatActivity {

    private TextView nameTV;
    private TextView descTV;
    private TextView priceTV;
    private ImageView itemIV;

    private TextView itemQuantity;
    private ImageView quantityMinus;
    private ImageView quantityAdd;
    private Button addOrder;

    private int oIID;
    private String oIName;
    private double oIPrice;
    private int oIImage;
    private int quantity;

    private Item item;
    private String status;

    private OrderItem oi;

    private Double total = 0.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_frag);

        Intent intent = getIntent();

        // Get the extra identified by "ArticleID" that was put into the intent at the origin.
        int itemID = intent.getIntExtra("ItemID", 0);

        // Now that we were passed the ID of the clicked item, we can get the rest of the data
        // from the "database". Imagine this could be a real SQL database.
        item = ItemDatabase.getItemById(itemID);

        nameTV = findViewById(R.id.dName);
        descTV = findViewById(R.id.dDesc);
        priceTV = findViewById(R.id.dPrice);
        itemIV = findViewById(R.id.dImage);
        itemQuantity = findViewById(R.id.dQuantity);
        quantityAdd = findViewById(R.id.addItem);
        quantityMinus = findViewById(R.id.lessItem);
        addOrder = findViewById(R.id.addToOrder);

        oIID = item.getItemID();
        oIName = item.getItemName();
        oIPrice = item.getItemPrice();
        oIImage = item.getDrawableID();

        nameTV.setText(oIName);
        descTV.setText(item.getItemDesc());
        priceTV.setText("$" + String.format("%.2f",oIPrice));



        quantityAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity = Integer.parseInt(itemQuantity.getText().toString());
                quantity = quantity + 1;
                itemQuantity.setText(Integer.toString(quantity));
                }
        });
        quantityMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity = Integer.parseInt(itemQuantity.getText().toString());
                if(quantity>0){
                    quantity = quantity-1;
                }
                itemQuantity.setText(Integer.toString(quantity));
            }
        });
        addOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity = Integer.parseInt(itemQuantity.getText().toString());
                total = total + oIPrice*quantity;

                Toast toast = Toast.makeText(getApplicationContext(),
                        "Order Updated: Added "+quantity+" x "+oIName+"\n"+"\n"+"Total Cost: $"+String.format("%.2f",total),
                        Toast.LENGTH_SHORT);
                toast.show();

                oi = new OrderItem(oIID,oIName,oIPrice,oIImage,quantity);

                orders.add(oi);
                orderList.orders = orders;
                orderList.total = orderList.total + total;

                total = 0.0;

            }
        });


        itemIV.setImageResource(oIImage);
    }


}
