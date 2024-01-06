package com.afaq.huts.details;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.afaq.huts.R;
import com.afaq.huts.adapters.BreakFastAdapter;
import com.afaq.huts.databinding.ActivityShinwariRestaurantBinding;
import com.afaq.huts.model.BreakfastClass;
import com.afaq.huts.ui.CartsActivity;

import java.util.ArrayList;

public class ShinwariRestaurantActivity extends AppCompatActivity {

    private ActivityShinwariRestaurantBinding binding;

    private ArrayList<BreakfastClass> breakfastList;
    private ArrayList<BreakfastClass> filteredList;
    private BreakFastAdapter adapter;
    private String hutName ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityShinwariRestaurantBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        hutName= getIntent().getStringExtra("hutname");

        binding.textView7.setText(hutName);


        breakfastList = new ArrayList<>();

        filteredList = new ArrayList<>();
        breakfastList.clear();
        filteredList.clear();

        breakfastList.add(new BreakfastClass("Seekh kabab", "120", R.drawable.seekhkabab));
        breakfastList.add(new BreakfastClass("BBQ", "180", R.drawable.bbq));
        breakfastList.add(new BreakfastClass("Chicken tikka leg", "300", R.drawable.chickentikaleg));
        breakfastList.add(new BreakfastClass("Chicken tikka chest", "300", R.drawable.chickentikachest));
        breakfastList.add(new BreakfastClass("Chicken karhai 1kg", "1600", R.drawable.chickenkhari));
        breakfastList.add(new BreakfastClass("Chicken karhai ½ kg", "800", R.drawable.chickenkhari));
        breakfastList.add(new BreakfastClass("Roti", "25", R.drawable.roti));
        breakfastList.add(new BreakfastClass("Naan", "30", R.drawable.naan));
        breakfastList.add(new BreakfastClass("Raita", "30", R.drawable.raita));
        breakfastList.add(new BreakfastClass("Salad", "50", R.drawable.saled));

        breakfastList.add(new BreakfastClass("Mineral water S", "60", R.drawable.water));
        breakfastList.add(new BreakfastClass("Mineral water L", "100", R.drawable.water));
        breakfastList.add(new BreakfastClass("Pepsi 200ml", "70", R.drawable.pepsi));
        breakfastList.add(new BreakfastClass("Pepsi 1 litre", "160", R.drawable.pepsi));
        breakfastList.add(new BreakfastClass("coke 1 litre", "160", R.drawable.coke));
        breakfastList.add(new BreakfastClass("Pepsi 500ml", "120", R.drawable.pepsi));
        breakfastList.add(new BreakfastClass("Pepsi 1.5 litre", "190", R.drawable.pepsi));
        breakfastList.add(new BreakfastClass("Coke 200ml", "70", R.drawable.coke));
        breakfastList.add(new BreakfastClass("Coke 500ml", "120", R.drawable.coke));
        breakfastList.add(new BreakfastClass("Coke 1.5 litre", "190", R.drawable.coke));

        breakfastList.add(new BreakfastClass("Disposable glass", "5", R.drawable.glasss));


        filteredList.addAll(breakfastList);

        adapter = new BreakFastAdapter(this, filteredList, hutName);

        binding.MajRec.setAdapter(adapter);
        binding.MajRec.setLayoutManager(new LinearLayoutManager(this));

        binding.btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.btncart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShinwariRestaurantActivity.this, CartsActivity.class));
            }
        });
        SearchView btnSearch = findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set focus on the SearchView
                btnSearch.setIconified(false);

                // Show the keyboard
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(btnSearch, InputMethodManager.SHOW_IMPLICIT);
            }
        });

        binding.btnSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Handle search query submission
                filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Handle query text changes
                filter(newText);
                return true;
            }
        });



    }

    private void filter(String query) {
        filteredList.clear();
        for (BreakfastClass item : breakfastList) {
            if (item.getName().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(item);
            }
        }


        if (filteredList.isEmpty()) {
            Toast.makeText(this, "No matching items found.", Toast.LENGTH_SHORT).show();
        }
        adapter.notifyDataSetChanged();
    }



}