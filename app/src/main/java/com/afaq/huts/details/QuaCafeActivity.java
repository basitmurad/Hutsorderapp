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
import com.afaq.huts.databinding.ActivityQuaCafe2Binding;

import com.afaq.huts.model.BreakfastClass;
import com.afaq.huts.ui.CartsActivity;


import java.util.ArrayList;

public class QuaCafeActivity extends AppCompatActivity {
    private ActivityQuaCafe2Binding binding;

    private ArrayList<BreakfastClass> list;
    private ArrayList<BreakfastClass> filteredList;
    private BreakFastAdapter adapter;
    private String hutName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuaCafe2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        hutName= getIntent().getStringExtra("hutname");
//
//        Toast.makeText(this, ""+hutName, Toast.LENGTH_SHORT).show();

        list = new ArrayList<>();
        filteredList = new ArrayList<>();
        list.clear();
        filteredList.clear();

        list.add(new BreakfastClass("Chicken Biryani", "220", R.drawable.chickenbiryani));
        list.add(new BreakfastClass("Qourma", "180", R.drawable.chickenqorma));
        list.add(new BreakfastClass("Daal", "120", R.drawable.dalchaney));
        list.add(new BreakfastClass("Aalu Qeema", "150", R.drawable.aluqeema));
        list.add(new BreakfastClass("Jalfrezi", "180", R.drawable.chickenjalferzi));
        list.add(new BreakfastClass("Sabzi", "120", R.drawable.sabzimix));
        list.add(new BreakfastClass("Chowmein", "250", R.drawable.chowin));
        list.add(new BreakfastClass("Chaney", "120", R.drawable.chaneychat));
        list.add(new BreakfastClass("Samosa Chat", "120", R.drawable.samosachat));
        list.add(new BreakfastClass("Dahi Baley", "120", R.drawable.dahibaley));
        list.add(new BreakfastClass("Chaney Chaat", "110", R.drawable.chaneychat));
        list.add(new BreakfastClass("Zinger Burger", "230", R.drawable.zingerburger));
        list.add(new BreakfastClass("Shawarma", "180", R.drawable.sharma));
        list.add(new BreakfastClass("Zinger Shawarma", "270", R.drawable.zingershawarma));
        list.add(new BreakfastClass("Paratha Roll", "250", R.drawable.paratharoll));
        list.add(new BreakfastClass("Anda Shami Burger", "150", R.drawable.andaburger));
        list.add(new BreakfastClass("Roti", "20", R.drawable.roti));
        list.add(new BreakfastClass("Paratha", "50", R.drawable.paratha));
        list.add(new BreakfastClass("Chai", "50", R.drawable.chaye));
        list.add(new BreakfastClass("Egg Fri", "50", R.drawable.eggfri));
        list.add(new BreakfastClass("Omelette", "50", R.drawable.omlete));

        list.add(new BreakfastClass("Mali boti", "250", R.drawable.maliboti));
        list.add(new BreakfastClass("BBQ piece", "250", R.drawable.bbq));
        list.add(new BreakfastClass("Beef kabab", "120", R.drawable.beefkabab));
        list.add(new BreakfastClass("Tikkat boti", "280", R.drawable.tikaboti));


        list.add(new BreakfastClass("Zinger shawarma", "250", R.drawable.zingershawarma));
        list.add(new BreakfastClass("Simple shawarma", "150", R.drawable.sharma));
        list.add(new BreakfastClass("Chicken sandwich", "220", R.drawable.sandwitch));
        list.add(new BreakfastClass("Club sandwich", "250", R.drawable.clubsandwich));
        list.add(new BreakfastClass("Chi roll paratha", "220", R.drawable.paratharoll));
        list.add(new BreakfastClass("Zinger roll paratha", "270", R.drawable.zingerroll));
        list.add(new BreakfastClass("Chicken burger", "220", R.drawable.chickenburger));
        list.add(new BreakfastClass("Zinger burger", "230", R.drawable.zingerburger));
        list.add(new BreakfastClass("Andashami burger", "150", R.drawable.andaburger));
        list.add(new BreakfastClass("Samosa chat", "120", R.drawable.samosachat));


        list.add(new BreakfastClass("Banana shake", "120", R.drawable.bananashake));
        list.add(new BreakfastClass("Oreo shake", "120", R.drawable.oreashake));
        list.add(new BreakfastClass("Apple shake", "120", R.drawable.appleshake));
        list.add(new BreakfastClass("Grapes juice", "130", R.drawable.graphjuice));
        list.add(new BreakfastClass("Fruit chat", "120", R.drawable.fruitchat));
        list.add(new BreakfastClass("Fruit chat special", "150", R.drawable.fruitchatspecial));
        list.add(new BreakfastClass("Masammi juice", "120", R.drawable.massamijuice));
        list.add(new BreakfastClass("Orange juice", "120", R.drawable.orangejuice));
        list.add(new BreakfastClass("Falsa juice", "130", R.drawable.falsajuice));
        list.add(new BreakfastClass("Mineral water S", "60", R.drawable.water));
        list.add(new BreakfastClass("Mineral water L", "100", R.drawable.water));
        list.add(new BreakfastClass("Pepsi 200ml", "70", R.drawable.pepsi));
        list.add(new BreakfastClass("Pepsi 1 litre", "160", R.drawable.pepsi));
        list.add(new BreakfastClass("coke 1 litre", "160", R.drawable.coke));
        list.add(new BreakfastClass("Pepsi 500ml", "120", R.drawable.pepsi));
        list.add(new BreakfastClass("Pepsi 1.5 litre", "190", R.drawable.pepsi));
        list.add(new BreakfastClass("Coke 200ml", "70", R.drawable.coke));
        list.add(new BreakfastClass("Coke 500ml", "120", R.drawable.coke));
        list.add(new BreakfastClass("Coke 1.5 litre", "190", R.drawable.coke));

        list.add(new BreakfastClass("Disposable glass", "5", R.drawable.glasss));

        filteredList.addAll(list);

        adapter = new BreakFastAdapter(this, filteredList,hutName);

        binding.QuaRec.setAdapter(adapter);
        binding.QuaRec.setLayoutManager(new LinearLayoutManager(this));

        binding.btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.btncart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuaCafeActivity.this, CartsActivity.class));
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

// Set the query listener as you have in your code
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
        for (BreakfastClass item : list) {
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