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
import com.afaq.huts.databinding.ActivityMalakandhutsBinding;
import com.afaq.huts.model.BreakfastClass;
import com.afaq.huts.ui.CartsActivity;

import java.util.ArrayList;

public class MalakandhutsActivity extends AppCompatActivity {
    ActivityMalakandhutsBinding binding;

    private ArrayList<BreakfastClass> breakfastList;
    private ArrayList<BreakfastClass> filteredList;
    private BreakFastAdapter adapter;
    private String hutName ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding =ActivityMalakandhutsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        hutName= getIntent().getStringExtra("hutname");
//        binding.textView7.setText(hutName);



        breakfastList = new ArrayList<>();

        filteredList = new ArrayList<>();
        breakfastList.clear();
        filteredList.clear();
        breakfastList.add(new BreakfastClass("Kabuli pulao", "300", R.drawable.kabulipulao));
        breakfastList.add(new BreakfastClass("Sada pulao", "200", R.drawable.sadapulao));
        breakfastList.add(new BreakfastClass("Chicken karhai Half", "800", R.drawable.chickenkhari));
        breakfastList.add(new BreakfastClass("Chicken karhai full", "1500", R.drawable.chickenkhari));
        breakfastList.add(new BreakfastClass("Chicken tikka", "180", R.drawable.tikaboti));
        breakfastList.add(new BreakfastClass("Namkeenrosh", "250", R.drawable.namkeenrosh));
        breakfastList.add(new BreakfastClass("Seekh kabab", "100", R.drawable.seekhkabab));
        breakfastList.add(new BreakfastClass("Seekh kabab fri", "150", R.drawable.seekhkabab));
        breakfastList.add(new BreakfastClass("Lobiyafri", "200", R.drawable.lobia));


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

        binding.btnback.setOnClickListener(v -> finish());

        binding.btncart.setOnClickListener(v -> startActivity(new Intent(MalakandhutsActivity.this, CartsActivity.class)));
        SearchView btnSearch = findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(v -> {
            // Set focus on the SearchView
            btnSearch.setIconified(false);

            // Show the keyboard
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(btnSearch, InputMethodManager.SHOW_IMPLICIT);
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