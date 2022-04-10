//++++++++++++++++++++++++++++++++++++++++++++++++
// Name: MainActivity.java
// Function: Main Activity
// Programmer: Deonna Owens
// Last Updated: 04/06/2022
//++++++++++++++++++++++++++++++++++++++++++++++++

package com.example.kcfapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        db_helper db = new db_helper(MainActivity.this);
        // format to add info to DB
        // name, address, food, clothingm shelter, healthcare
        //  > food, clothingm shelter, healthcare: takes int, 0 for false, 1 for true
        db.addNewLocation("tesy", "test2", 1, 0, 1, 1);

        MaterialButton refugeeBtn = findViewById(R.id.refugeeBtn);
        MaterialButton donorBtn = findViewById(R.id.donorBtn);

        donorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, donor_page.class));
            }
        });
    }
}
