package com.example.borgerkong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class DetailActivity extends AppCompatActivity {

    private TextView nameTV;
    private TextView descTV;
    private TextView priceTV;
    private ImageView itemIV;

    private TextView itemQuantity;
    private ImageView quantityMinus;
    private ImageView quantityAdd;
    private Button addOrder;

    private int quantity;
    private String sq;
    private String iName;
    private double iPrice;
    private int iImage;

    private Item item;
    private String status;

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

        // Set the views to show the data of our object
        iName = item.getItemName();
        iPrice = item.getItemPrice();
        iImage = item.getDrawableID();

        nameTV.setText(iName);
        descTV.setText(item.getItemDesc());
        priceTV.setText("$" + String.format("%.2f",iPrice));



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
                quantity = quantity - 1;
                itemQuantity.setText(Integer.toString(quantity));
            }
        });
        addOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity = Integer.parseInt(itemQuantity.getText().toString());
                total = total + iPrice*quantity;

                Toast toast = Toast.makeText(getApplicationContext(),
                        "Order Updated: Added "+Math.abs(quantity)+" x "+iName+"\n"+"\n"+"Price Updated: $"+ String.format("%.2f",total),
                        Toast.LENGTH_SHORT);
                toast.show();

                total = 0.0;



            }
        });


        itemIV.setImageResource(iImage);
    }


}
