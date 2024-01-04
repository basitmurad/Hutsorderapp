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
import com.afaq.huts.databinding.ActivityKarachihutsBinding;
import com.afaq.huts.model.BreakfastClass;
import com.afaq.huts.ui.CartsActivity;

import java.util.ArrayList;

public class KarachihutsActivity extends AppCompatActivity {

    ActivityKarachihutsBinding binding;
    private ArrayList<BreakfastClass> breakfastList;
    private ArrayList<BreakfastClass> filteredList;
    private BreakFastAdapter adapter;
    private String hutName ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityKarachihutsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        hutName= getIntent().getStringExtra("hutname");

        binding.textView7.setText(hutName);



        breakfastList = new ArrayList<>();

        filteredList = new ArrayList<>();
        breakfastList.clear();
        filteredList.clear();
        breakfastList.add(new BreakfastClass("Kabuli pulao", "300", R.drawable.kabulipulao));
        breakfastList.add(new BreakfastClass("Chi Manchurian w rice", "380", R.drawable.manchurianrice));
        breakfastList.add(new BreakfastClass("Chi Shashlik w rice", "380", R.drawable.shashlikrice));
        breakfastList.add(new BreakfastClass("Chi Chilli dry w rice", "380", R.drawable.chillirice));
        breakfastList.add(new BreakfastClass("Garlic Chi w rice", "380", R.drawable.garlic_chi_with_rice));
        breakfastList.add(new BreakfastClass("Chicken chowmein", "350", R.drawable.chickenchowmein));
        breakfastList.add(new BreakfastClass("Egg fried rice", "200", R.drawable.eggfiedrice));
        breakfastList.add(new BreakfastClass("Vegetables rice", "200", R.drawable.vegetables_rice));
        breakfastList.add(new BreakfastClass("Chicken fried rice", "250", R.drawable.chickengriedrice));
        breakfastList.add(new BreakfastClass("Alfredo Pasta", "350", R.drawable.alfredo_pasta));
        breakfastList.add(new BreakfastClass("Cajun pasta", "350", R.drawable.canjupasta));
        breakfastList.add(new BreakfastClass("Spicy red sauce pasta", "350", R.drawable.spicy_red_sauce_pasta));
        breakfastList.add(new BreakfastClass("Moroccan Chi pasta", "350", R.drawable.moroccan_chi_pasta));
        breakfastList.add(new BreakfastClass("Zinger burger", "300", R.drawable.zingerburger));
        breakfastList.add(new BreakfastClass("Grilled Chi burger", "300", R.drawable.burger));
        breakfastList.add(new BreakfastClass("Cheese burger", "350", R.drawable.cheeseburger));
        breakfastList.add(new BreakfastClass("Chi Shawarma", "150", R.drawable.sharma));
        breakfastList.add(new BreakfastClass("Zinger Shawarma", "250", R.drawable.zingershawarma));
        breakfastList.add(new BreakfastClass("Chi roll paratha", "150", R.drawable.chickenrollparatha));
        breakfastList.add(new BreakfastClass("Zinger roll paratha", "250", R.drawable.zingerroll));
        breakfastList.add(new BreakfastClass("Club sandwich", "250", R.drawable.sandwitch));
        breakfastList.add(new BreakfastClass("BBQ sandwich", "250", R.drawable.bbq_sandwich));
        breakfastList.add(new BreakfastClass("Chi wings 8 pcs", "400", R.drawable.wings));
        breakfastList.add(new BreakfastClass("Chi fingers", "400", R.drawable.chi_fingers));
        breakfastList.add(new BreakfastClass("Mayo fries", "200", R.drawable.mayofries));
        breakfastList.add(new BreakfastClass("Momos 12 pcs", "280", R.drawable.momos));
        breakfastList.add(new BreakfastClass("Momos 6 pcs", "140", R.drawable.momos));
        breakfastList.add(new BreakfastClass("Chicken soup", "150", R.drawable.chickensoap));
        breakfastList.add(new BreakfastClass("Chi karhai 1kg", "1500", R.drawable.chickenkhari));
        breakfastList.add(new BreakfastClass("Chi karhahi 1/2 kg", "800", R.drawable.chickenkhari));
        breakfastList.add(new BreakfastClass("White karhai 1kg", "1500", R.drawable.white_karhai_1kg));
        breakfastList.add(new BreakfastClass("White karhai 1/2 kg", "800", R.drawable.white_karhai_1kg));
        breakfastList.add(new BreakfastClass("Chi handi S", "200", R.drawable.chi_handi_f));
        breakfastList.add(new BreakfastClass("Chi handi F", "300", R.drawable.chi_handi_f));
        breakfastList.add(new BreakfastClass("Chi madrassi S", "200", R.drawable.chimadrassi));
        breakfastList.add(new BreakfastClass("Chi madrassi F", "300", R.drawable.chimadrassi));
        breakfastList.add(new BreakfastClass("Masammi juice", "140", R.drawable.massamijuice));
        breakfastList.add(new BreakfastClass("Orange juice", "140", R.drawable.orangejuice));
        breakfastList.add(new BreakfastClass("Banana shake", "120", R.drawable.bananashake));
        breakfastList.add(new BreakfastClass("Oreo shake", "120", R.drawable.oreashake));
        breakfastList.add(new BreakfastClass("Fruit chat", "150", R.drawable.fruitchat));
        breakfastList.add(new BreakfastClass("Chaye", "60", R.drawable.chaye));
        breakfastList.add(new BreakfastClass("Paratha", "50", R.drawable.paratha));
        breakfastList.add(new BreakfastClass("Aalu paratha", "100", R.drawable.alooparatha));
        breakfastList.add(new BreakfastClass("Aalu cheese paratha", "150", R.drawable.alocheeseparatha));
        breakfastList.add(new BreakfastClass("Omlete", "50", R.drawable.omlete));
        breakfastList.add(new BreakfastClass("Andafri", "50", R.drawable.andafri));


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
                startActivity(new Intent(KarachihutsActivity.this, CartsActivity.class));
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