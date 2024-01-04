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
import com.afaq.huts.databinding.ActivityFoodieshutsBinding;
import com.afaq.huts.databinding.ActivityJanbiryaniBinding;
import com.afaq.huts.model.BreakfastClass;
import com.afaq.huts.ui.CartsActivity;

import java.util.ArrayList;

public class FoodieshutsActivity extends AppCompatActivity {

    private ActivityFoodieshutsBinding binding;
    private ArrayList<BreakfastClass> breakfastList;
    private ArrayList<BreakfastClass> filteredList;
    private BreakFastAdapter adapter;
    private String hutName ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFoodieshutsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        hutName= getIntent().getStringExtra("hutname");

        binding.textView7.setText(hutName);


        breakfastList = new ArrayList<>();

        filteredList = new ArrayList<>();
        breakfastList.clear();
        filteredList.clear();

        breakfastList.add(new BreakfastClass("Sada biryani S", "150", R.drawable.sadabiryani));
        breakfastList.add(new BreakfastClass("Chappal kabab S", "120",R.drawable.chappalkabab)); // Add the corresponding drawable resource
        breakfastList.add(new BreakfastClass("Chappal kabab L", "180", R.drawable.chappalkabab)); // Add the corresponding drawable resource
        breakfastList.add(new BreakfastClass("Shami pulao S", "200",R.drawable.shamipulao)); // Add the corresponding drawable resource
        breakfastList.add(new BreakfastClass("Shami pulao F", "300", R.drawable.shamipulao)); // Add the corresponding drawable resource
        breakfastList.add(new BreakfastClass("Seekh kabab", "120",R.drawable.seekhkabab)); // Add the corresponding drawable resource
        breakfastList.add(new BreakfastClass("Chicken tikka leg/chest", "350",R.drawable.tikaboti)); // Add the corresponding drawable resource
        breakfastList.add(new BreakfastClass("Chicken karhai half", "800", R.drawable.chickenkhari)); // Add the corresponding drawable resource
        breakfastList.add(new BreakfastClass("Chicken karhai full", "1600", R.drawable.chickenkhari)); // Add the corresponding drawable resource

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
                startActivity(new Intent(FoodieshutsActivity.this, CartsActivity.class));
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