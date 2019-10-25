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
import java.util.ArrayList;


public class OrderFrag extends Fragment {

    RecyclerView recyclerView;
    TextView title;
    TextView total;
    Double amtTotal;

    public OrderFrag() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);

        recyclerView = view.findViewById(R.id.rv_order);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);




//        OrderAdapter oAdapter = new OrderAdapter();
//        oAdapter.setData(OrderDatabase.getAllItems());
//
//        recyclerView.setAdapter(oAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity parent = (MainActivity) getActivity();
    }

}
