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

        food.setOnClickListener(this);
        clothing.setOnClickListener(this);
        shelter.setOnClickListener(this);
        healthcare.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.food:
                Toast.makeText(this, "food selected.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.clothing:
                Toast.makeText(this, "clothing selected.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.shelter:
                Toast.makeText(this, "shelter selected.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.healthcare:
                Toast.makeText(this, "healthcare selected.", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}