package com.example.kcfapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db_helper db = new db_helper(MainActivity.this);
        //db.addNewLocation("test", "test2", 1, 0, 1, 1);

        MaterialButton refugeeBtn = findViewById(R.id.refugeeBtn);
        MaterialButton donorBtn = findViewById(R.id.donorBtn);

        refugeeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, need.class));
            }
        });

        donorBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, donor_page.class));
            }
        });
    }
}