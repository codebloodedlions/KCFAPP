package com.example.kcfapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class food extends AppCompatActivity {
    db_helper foodDB;
    locationOBJ OBJ;
    List<locationOBJ> ld = new ArrayList<>();
    ArrayAdapter ad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        ListView list = findViewById(R.id.list);

        foodDB = new db_helper(this);
        ld = foodDB.getLocationData();
        ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ld);
        list.setAdapter(ad);
    }


}