package com.example.adaptit.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.adaptit.adapters.Adapter;
import com.example.adaptit.Bursary;
import com.example.adaptit.R;
import com.example.adaptit.databinding.ActivityHomeBinding;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    private RecyclerView recyclerViewBursaryList;
    private ActivityHomeBinding binding;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerViewBursary();
    }

    private void recyclerViewBursary() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewBursaryList = findViewById(R.id.recyclerViewBursary);
        recyclerViewBursaryList.setLayoutManager(linearLayoutManager);

        ArrayList<Bursary> category = new ArrayList<>();
        category.add(new Bursary("Undergrad 2024", "AdaptIT", "Make your future!"));
        category.add(new Bursary("Empower the future", "AdaptIT", "Graduate program!"));
        category.add(new Bursary("NextGen", "Wits", "Merit Award"));

        adapter = new Adapter(category);
        recyclerViewBursaryList.setAdapter(adapter);
    }
}