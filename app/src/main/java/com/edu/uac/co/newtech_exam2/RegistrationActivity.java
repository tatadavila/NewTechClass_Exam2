package com.edu.uac.co.newtech_exam2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button btnRegister, btnCancel;
    private EditText etId, etName, etWage;
    private Spinner spStratum, spEduLevel;
    ArrayAdapter<CharSequence> stratumSpAdapter, eduLevelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etId = findViewById(R.id.userIdEt);
        etName = findViewById(R.id.userIdEt);
        spStratum = findViewById(R.id.userStratumSp);
        etWage = findViewById(R.id.userWageEt);
        spEduLevel = findViewById(R.id.userEduLevelSp);

        stratumSpAdapter = ArrayAdapter.createFromResource(this, R.array.sNumbers, android.R.layout.simple_spinner_dropdown_item);
        eduLevelAdapter = ArrayAdapter.createFromResource(this, R.array.eduLevels, android.R.layout.simple_spinner_dropdown_item);

        stratumSpAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        eduLevelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spStratum.setAdapter(stratumSpAdapter);
        spEduLevel.setAdapter(eduLevelAdapter);

        spStratum.setOnItemSelectedListener(this);
        spEduLevel.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String txtStratum, txtEduLevel;

        switch(parent.getId()) {
            case R.id.userStratumSp:
                txtStratum = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), txtStratum, Toast.LENGTH_LONG).show();
                break;

            case R.id.userEduLevelSp:
                txtEduLevel = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), txtEduLevel, Toast.LENGTH_LONG).show();
                break;
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
