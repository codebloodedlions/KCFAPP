package com.example.kcfapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_need);

        Button food = findViewById(R.id.food);
        Button clothing = findViewById(R.id.clothing);
        Button shelter = findViewById(R.id.shelter);
        Button healthcare = findViewById(R.id.healthcare);
        Button submit = findViewById(R.id.submit);

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // set the color to relative layout
                food.setSelected(!food.isSelected());
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
                healthcare.setSelected(!healthcare.isSelected());
                // set the color to relative layout
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}