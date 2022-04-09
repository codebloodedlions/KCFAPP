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

public class donor_page extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_page);


        TextView nameTextView, serviceTextView, pubOrPrivTextView;

        EditText nameEditText = findViewById(R.id.nameEditText);

        CheckBox foodCheckBox = findViewById(R.id.foodCheckBox);
        CheckBox clothingCheckBox = findViewById(R.id.clothingCheckBox);
        CheckBox shelterCheckBox = findViewById(R.id.shelterCheckBox);
        CheckBox HealthCheckBox = findViewById(R.id.healthCheckBox);

        Spinner pubOrPrivSpinner = findViewById(R.id.pubOrPrivSpinner);

        Button submitBtn = findViewById(R.id.submitBtn);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.classification, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pubOrPrivSpinner.setAdapter(adapter);
        pubOrPrivSpinner.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        String text = parent.getItemAtPosition(i).toString();
        //Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
