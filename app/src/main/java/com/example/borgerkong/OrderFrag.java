package com.example.borgerkong;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import static com.example.borgerkong.MainActivity.orderList;
import static com.example.borgerkong.MainActivity.orders;
import static java.lang.String.format;


public class OrderFrag extends Fragment {

    RecyclerView recyclerView;
    TextView title;
    TextView total;
    Double amtTotal;
    NumberFormat format = new DecimalFormat("#0.00");

    public OrderFrag() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view2 = inflater.inflate(R.layout.fragment_order, container, false);

        total = view2.findViewById(R.id.orderAmt);
        amtTotal = orderList.total;

        total.setText("$"+ format.format(amtTotal));


        recyclerView = view2.findViewById(R.id.rv_order);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(view2.getContext());
        recyclerView.setLayoutManager(layoutManager2);

        OrderAdapter oAdapter = new OrderAdapter();

        oAdapter.setData(orders);
        recyclerView.setAdapter(oAdapter);

        return view2;
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity parent = (MainActivity) getActivity();
    }

}
