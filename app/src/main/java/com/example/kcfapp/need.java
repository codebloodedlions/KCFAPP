package com.example.kcfapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class need extends AppCompatActivity implements View.OnClickListener {

    Button food, clothing, shelter, healthcare;
    db_helper donorDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_need);

        food = findViewById(R.id.food);
        clothing = findViewById(R.id.clothing);
        shelter = findViewById(R.id.shelter);
        healthcare = findViewById(R.id.healthcare);

        donorDB = new db_helper(this);

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // set the color to relative layout
                food.setSelected(!food.isSelected());
                startActivity(new Intent(need.this, food.class));

            }
        });

        clothing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // set the color to relative layout
                clothing.setSelected(!clothing.isSelected());

            }
        });

        shelter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // set the color to relative layout
                shelter.setSelected(!shelter.isSelected());

            }
        });

        healthcare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // set the color to relative layout
                healthcare.setSelected(!healthcare.isSelected());

            }
        });


    }

    @Override
    public void onClick(View view) {


    }

}