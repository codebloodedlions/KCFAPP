package com.example.kcfapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class donor_page extends AppCompatActivity {

    Button submitBtn;
    db_helper donorDB;
    EditText nameEditText, addressEditText;
    CheckBox foodCheckBox,clothingCheckBox, shelterCheckBox, healthCheckBox;
    int food, clothing, shelter, health;
    TextView nameTextView, serviceTextView, addressTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_page);

        donorDB = new db_helper(this);

        nameEditText = findViewById(R.id.nameEditText);
        addressEditText = findViewById(R.id.addressEditText);

        foodCheckBox = findViewById(R.id.foodCheckBox);
        clothingCheckBox = findViewById(R.id.clothingCheckBox);
        shelterCheckBox = findViewById(R.id.shelterCheckBox);
        healthCheckBox = findViewById(R.id.healthCheckBox);

        serviceTextView = findViewById(R.id.serviceTextView);

        submitBtn = findViewById(R.id.submitBtn);

        AddData();

    }


    public void AddData() {
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //food
                if(foodCheckBox.isChecked()) {
                    //Toast.makeText(donor_page.this,"Checked", Toast.LENGTH_LONG).show();
                    food = 1;
                }
                else {
                    food = 0;
                }

                //clothing
                if(clothingCheckBox.isChecked()) {
                    clothing = 1;
                }
                else {
                    clothing = 0;
                }

                //shelter
                if(shelterCheckBox.isChecked()) {
                    shelter = 1;
                }
                else {
                    shelter = 0;
                }

                //health
                if(healthCheckBox.isChecked()) {
                    health = 1;
                }
                else {
                    health = 0;
                }



                String address = addressEditText.getText().toString();
                String name = nameEditText.getText().toString();
                donorDB.addNewLocation(name, address, food, clothing, shelter, health);

                boolean check = validateInfo(name, address, food, clothing, shelter, health);
                if(check == true) {
                    Toast.makeText(donor_page.this, "Successfully Registered", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(donor_page.this, MainActivity.class));
                }
                else {
                    Toast.makeText(donor_page.this, "Sorry! Could not register. Please check information again", Toast.LENGTH_LONG).show();
                }


            }
        });
    }

    private boolean validateInfo(String name, String address, int food, int clothing, int shelter, int health) {
         if(name.isEmpty()) {
             nameEditText.setError("This field is required");
         }
         if(address.isEmpty()) {
             addressEditText.setError("This field is required");
         }

         if(food == 0 && clothing == 0 && shelter == 0 && health == 0) {
             serviceTextView.setError("Check at least 1 box");

         }

         else {
             return true;
         }

        return false;
    }
}
