package com.example.kcfapp;

import androidx.appcompat.app.AppCompatActivity;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_page);


        TextView nameTextView, serviceTextView, addressTextView;

        EditText nameEditText = findViewById(R.id.nameEditText);
        EditText addressEditText = findViewById(R.id.addressEditText);

        CheckBox foodCheckBox = findViewById(R.id.foodCheckBox);
        CheckBox clothingCheckBox = findViewById(R.id.clothingCheckBox);
        CheckBox shelterCheckBox = findViewById(R.id.shelterCheckBox);
        CheckBox HealthCheckBox = findViewById(R.id.healthCheckBox);

        Button submitBtn = findViewById(R.id.submitBtn);


    }

}
