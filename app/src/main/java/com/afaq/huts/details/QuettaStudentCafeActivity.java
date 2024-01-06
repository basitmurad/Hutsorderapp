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
import com.afaq.huts.databinding.ActivityQuettaStudentCafeBinding;
import com.afaq.huts.model.BreakfastClass;
import com.afaq.huts.ui.CartsActivity;

import java.util.ArrayList;

public class QuettaStudentCafeActivity extends AppCompatActivity {

    ActivityQuettaStudentCafeBinding binding;
    private ArrayList<BreakfastClass> breakfastList;
    private ArrayList<BreakfastClass> filteredList;
    private BreakFastAdapter adapter;
    private String hutName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityQuettaStudentCafeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        hutName = getIntent().getStringExtra("hutname");

//        binding.textView7.setText(hutName);


        breakfastList = new ArrayList<>();

        filteredList = new ArrayList<>();
        breakfastList.clear();
        filteredList.clear();

        breakfastList.add(new BreakfastClass("Chaye simple", "50", R.drawable.chaye));
        breakfastList.add(new BreakfastClass("chayegurhwali", "70", R.drawable.chayegurhwali));
        breakfastList.add(new BreakfastClass("Aalu paratha", "100", R.drawable.alooparatha));
        breakfastList.add(new BreakfastClass("Aalu cheese paratha", "150", R.drawable.alocheeseparatha));
        breakfastList.add(new BreakfastClass("Chocolate paratha", "150", R.drawable.chocolate_paratha));
        breakfastList.add(new BreakfastClass("Chicken paratha", "200", R.drawable.chicken_paratha));
        breakfastList.add(new BreakfastClass("Chi cheese paratha", "250", R.drawable.chi_cheese_paratha));
        breakfastList.add(new BreakfastClass("Malaiwala paratha", "130", R.drawable.malaiwala_paratha));
        breakfastList.add(new BreakfastClass("Andafri", "50", R.drawable.andafri));
        breakfastList.add(new BreakfastClass("Omlete", "50", R.drawable.omlete));
        breakfastList.add(new BreakfastClass("Chaney S", "110", R.drawable.chaneychat));
        breakfastList.add(new BreakfastClass("Chaney F", "160", R.drawable.chaneychat));


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
                startActivity(new Intent(QuettaStudentCafeActivity.this, CartsActivity.class));
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