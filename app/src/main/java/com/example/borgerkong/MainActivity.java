package com.example.borgerkong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView botNavView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = new ItemsFrag();
        swapFragment(fragment);

        botNavView = findViewById(R.id.bot_nav);
        botNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.nav_items) {
                    Fragment fragment = new ItemsFrag();
                    swapFragment(fragment);
                    return true;
                } else if (menuItem.getItemId() == R.id.nav_order) {
                    Fragment fragment = new OrderFrag();
                    swapFragment(fragment);
                    return true;
                }
                return false;
            }
        });
    }

        private void swapFragment(Fragment fragment) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frag_slot, fragment);
            fragmentTransaction.commit();
        }

    public void onFragmentInteraction(String string) {

    }

    public void showCoolMessage(String string) {
        Toast.makeText(this, "Quantity: " + string, Toast.LENGTH_SHORT).show();

    }

//        View view = findViewById(R.id.rv_main);
//
//        recyclerView = view.findViewById(R.id.rv_main);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
//        recyclerView.setLayoutManager(layoutManager);
//
//        ItemAdapter iAdapter = new ItemAdapter();
//
//        iAdapter.setData(ItemDatabase.getAllItems());
//        recyclerView.setAdapter(iAdapter);

    }

