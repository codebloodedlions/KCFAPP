package com.example.kcfapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class need extends AppCompatActivity {

    db_helper db;
    RecyclerView rvPrograms;
    locationOBJAdapter obj;
    RecyclerView.LayoutManager layoutManager;
    List<locationOBJ> orgList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_need);
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