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
import com.afaq.huts.databinding.ActivityShahidlahorinaashtaBinding;
import com.afaq.huts.model.BreakfastClass;
import com.afaq.huts.ui.CartsActivity;

import java.util.ArrayList;

public class ShahidlahorinaashtaActivity extends AppCompatActivity {

    ActivityShahidlahorinaashtaBinding binding;

    private ArrayList<BreakfastClass> breakfastList;
    private ArrayList<BreakfastClass> filteredList;
    private BreakFastAdapter adapter;
    private String hutName ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityShahidlahorinaashtaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        hutName= getIntent().getStringExtra("hutname");

        binding.textView7.setText(hutName);


        breakfastList = new ArrayList<>();

        filteredList = new ArrayList<>();
        breakfastList.clear();
        filteredList.clear();

        breakfastList.add(new BreakfastClass("Chaye", "50", R.drawable.chaye));
        breakfastList.add(new BreakfastClass("Bdepaye S", "180", R.drawable.bdepaye_s));
        breakfastList.add(new BreakfastClass("Bdepaye F", "300", R.drawable.bdepaye_s));
        breakfastList.add(new BreakfastClass("Beef nihari S", "180", R.drawable.beef_nihari_f));
        breakfastList.add(new BreakfastClass("Beef nihari F", "300", R.drawable.beef_nihari_f));
        breakfastList.add(new BreakfastClass("Lahori chaney S", "110", R.drawable.lahorichaneyingle));
        breakfastList.add(new BreakfastClass("Lahori chaney F", "160", R.drawable.lahorichaneyingle));
        breakfastList.add(new BreakfastClass("Andachaney S", "150", R.drawable.andachaney));
        breakfastList.add(new BreakfastClass("Andachaney F", "200", R.drawable.andachaney));
        breakfastList.add(new BreakfastClass("Acharichaney S", "110", R.drawable.acharichanney));
        breakfastList.add(new BreakfastClass("Acharichaney F", "160", R.drawable.acharichanney));
        breakfastList.add(new BreakfastClass("Aaluqeema S", "180", R.drawable.aluqeema));
        breakfastList.add(new BreakfastClass("Aaluqeema F", "300", R.drawable.aluqeema));
        breakfastList.add(new BreakfastClass("Maghazfri S", "180", R.drawable.maghazfri_s));
        breakfastList.add(new BreakfastClass("Maghazfri F", "300", R.drawable.maghazfri_s));
        breakfastList.add(new BreakfastClass("Haleem S", "110", R.drawable.haleem));
        breakfastList.add(new BreakfastClass("Haleem full", "160", R.drawable.haleem));
        breakfastList.add(new BreakfastClass("Chi Haleem S", "160", R.drawable.haleem));
        breakfastList.add(new BreakfastClass("Chi Haleem F", "210", R.drawable.haleem));
        breakfastList.add(new BreakfastClass("Halwapoori", "160", R.drawable.halwapoori));
        breakfastList.add(new BreakfastClass("Jaammalai", "80", R.drawable.jammalai));
        breakfastList.add(new BreakfastClass("Roghni naan", "50", R.drawable.roghnnaan));
        breakfastList.add(new BreakfastClass("Tandoori paratha", "50", R.drawable.tandorriparatha));
        breakfastList.add(new BreakfastClass("Sada naan", "30", R.drawable.naan));
        breakfastList.add(new BreakfastClass("Paratha", "50", R.drawable.paratha));
        breakfastList.add(new BreakfastClass("Dahi", "60", R.drawable.dahi));
        breakfastList.add(new BreakfastClass("Raita/salad", "80", R.drawable.raita_salad));


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
                startActivity(new Intent(ShahidlahorinaashtaActivity.this, CartsActivity.class));
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