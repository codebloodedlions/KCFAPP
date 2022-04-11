package com.example.kcfapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class food extends AppCompatActivity {

    db_helper db;
    RecyclerView rvPrograms;
    locationOBJAdapter obj;
    RecyclerView.LayoutManager layoutManager;
    List<locationOBJ> orgList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        db = new db_helper(this);
        //obj = new locationOBJAdapter(this);
        orgList = db.getLocationData();
        rvPrograms = findViewById(R.id.rvPrograms);
        rvPrograms.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvPrograms.setLayoutManager(layoutManager);
        obj = new locationOBJAdapter(this, orgList, rvPrograms);
        rvPrograms.setAdapter(obj);

    }
}