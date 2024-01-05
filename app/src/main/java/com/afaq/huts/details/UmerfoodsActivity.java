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
import com.afaq.huts.databinding.ActivityUmerfoodsBinding;
import com.afaq.huts.model.BreakfastClass;
import com.afaq.huts.ui.CartsActivity;

import java.util.ArrayList;

public class UmerfoodsActivity extends AppCompatActivity {


    ActivityUmerfoodsBinding binding;
    private ArrayList<BreakfastClass> breakfastList;
    private ArrayList<BreakfastClass> filteredList;
    private BreakFastAdapter adapter;
    private String hutName ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUmerfoodsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        hutName= getIntent().getStringExtra("hutname");

        binding.textView7.setText(hutName);


        breakfastList = new ArrayList<>();

        filteredList = new ArrayList<>();
        breakfastList.clear();
        filteredList.clear();


        breakfastList.add(new BreakfastClass("Chaye", "50", R.drawable.chaye));
        breakfastList.add(new BreakfastClass("Paratha", "50", R.drawable.paratha));
        breakfastList.add(new BreakfastClass("Andafri", "50", R.drawable.andafri));
        breakfastList.add(new BreakfastClass("Omlete", "50", R.drawable.omlete));
        breakfastList.add(new BreakfastClass("chaney S", "110", R.drawable.dalchaney));
        breakfastList.add(new BreakfastClass("chaney F", "160", R.drawable.dalchaney));
        breakfastList.add(new BreakfastClass("Shahichaney S", "160", R.drawable.shahichaney_s));
        breakfastList.add(new BreakfastClass("Shahichaney F", "210", R.drawable.shahichaney_s));
        breakfastList.add(new BreakfastClass("Chicken karhaihalf", "750", R.drawable.chickenkhari));
        breakfastList.add(new BreakfastClass("Chicken karhaifull", "1500", R.drawable.chickenkhari));
        breakfastList.add(new BreakfastClass("Chi boneless karhai half", "900", R.drawable.chi_boneless_karhai_half));
        breakfastList.add(new BreakfastClass("Chi boneless karhai full", "1800", R.drawable.chi_boneless_karhai_half));
        breakfastList.add(new BreakfastClass("White karhai half", "800", R.drawable.white_karhai_1kg));
        breakfastList.add(new BreakfastClass("White karhai full", "1600", R.drawable.white_karhai_1kg));
        breakfastList.add(new BreakfastClass("Acharikarhai half", "800", R.drawable.chickenachari));
        breakfastList.add(new BreakfastClass("Acharikarhai full", "1600", R.drawable.chickenkhari));
        breakfastList.add(new BreakfastClass("Sabzi S", "120", R.drawable.sabzimix));
        breakfastList.add(new BreakfastClass("Sabzi F", "160", R.drawable.sabzimix));
        breakfastList.add(new BreakfastClass("Daal S", "120", R.drawable.daal));
        breakfastList.add(new BreakfastClass("Daal F", "160", R.drawable.daal));
        breakfastList.add(new BreakfastClass("Lobiya S", "120", R.drawable.lobia));
        breakfastList.add(new BreakfastClass("Lobiya F", "160", R.drawable.lobia));
        breakfastList.add(new BreakfastClass("Chicken Shawarma", "150", R.drawable.sharma));
        breakfastList.add(new BreakfastClass("Chi cheese shawarma", "200", R.drawable.chickenshawarma));
        breakfastList.add(new BreakfastClass("Chicken roll paratha", "150", R.drawable.paratharoll));
        breakfastList.add(new BreakfastClass("Chi chips roll paratha", "200", R.drawable.chickenrollparatha));
        breakfastList.add(new BreakfastClass("Chicken zinger burger", "250", R.drawable.zingerburger));
        breakfastList.add(new BreakfastClass("Chicken burger", "150", R.drawable.burger));
        breakfastList.add(new BreakfastClass("Chicken hotshot", "250", R.drawable.chicken_hotshot));
        breakfastList.add(new BreakfastClass("French fries", "150", R.drawable.fries));
        breakfastList.add(new BreakfastClass("Wings", "250", R.drawable.wings));
        breakfastList.add(new BreakfastClass("Aalu samosa", "35", R.drawable.samosa));
        breakfastList.add(new BreakfastClass("Sabzi roll", "40", R.drawable.sabzi_roll));
        breakfastList.add(new BreakfastClass("Samosa chat", "120", R.drawable.samosachat));
        breakfastList.add(new BreakfastClass("Chana chat", "120", R.drawable.chaneychat));
        breakfastList.add(new BreakfastClass("Chicken fried rice", "260", R.drawable.chickengriedrice));
        breakfastList.add(new BreakfastClass("Egg fried rice", "200", R.drawable.eggfiedrice));
        breakfastList.add(new BreakfastClass("Vegetable fried rice", "200", R.drawable.vegetables_rice));
        breakfastList.add(new BreakfastClass("Chi manchurian w rice", "400", R.drawable.manchurianrice));
        breakfastList.add(new BreakfastClass("Chi shashlik w rice", "400", R.drawable.shashlikrice));
        breakfastList.add(new BreakfastClass("Chi dry chilli w rice", "400", R.drawable.chillirice));
        breakfastList.add(new BreakfastClass("Chi hot & spice rice", "300", R.drawable.hotandsoursoup));
        breakfastList.add(new BreakfastClass("Chi chowmein", "250", R.drawable.chowin));
        breakfastList.add(new BreakfastClass("Vegetable chowmein", "200", R.drawable.chowin));
        breakfastList.add(new BreakfastClass("Chicken corn soup", "160", R.drawable.chicornsoup));
        breakfastList.add(new BreakfastClass("Chi hot & Sour soup", "210", R.drawable.hotandsoursoup));


//    w BreakfastClass("Chicken fried rice", "260", R.drawable.chickengriedrice));
//        breakfastList.add(new BreakfastClass("Egg fried rice", "200", R.drawable.eggfiedrice));
//        breakfastList.add(new BreakfastClass("Vegetable fried rice", "200", R.drawable.vegetables_rice));
//        breakfastList.add(new BreakfastClass("Chi manchurian w rice", "400", R.drawable.manchurianrice));
//        breakfastList.add(new BreakfastClass("Chi shashlik w rice", "400", R.drawable.shashlikrice));
//        breakfastList.add(new BreakfastClass("Chi dry chilli w rice", "400", R.drawable.chillirice));
//        breakfastList.add(new BreakfastClass("Chi hot & spice rice", "300", R.drawable.hotandsoursoup));
//        breakfastList.add(new BreakfastClass("Chi chowmein", "250", R.drawable.chowin));
//        breakfastList.add(new BreakfastClass("Vegetable chowmein", "200", R.drawable.chowin));
//        breakfastList.add(new BreakfastClass("Chicken corn soup", "160", R.drawable.chicornsoup));
//        breakfastList.add(new BreakfastClass("Chi hot & Sour soup", "210", R.drawable.hotandsoursoup));


//asdasdasdasd



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
                startActivity(new Intent(UmerfoodsActivity.this, CartsActivity.class));
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