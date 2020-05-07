package com.edu.uac.co.newtech_exam2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button btnRegister, btnCancel;
    private EditText etId, etName, etWage;
    private Spinner spStratum, spEduLevel;

    private User usr;
    private UserController uC;

    ArrayAdapter<CharSequence> stratumSpAdapter, eduLevelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        btnRegister = findViewById(R.id.registerBtn);
        btnCancel = findViewById(R.id.cancelBtn);
        etId = findViewById(R.id.userIdEt);
        etName = findViewById(R.id.userNameEt);
        spStratum = findViewById(R.id.userStratumSp);
        etWage = findViewById(R.id.userWageEt);
        spEduLevel = findViewById(R.id.userEduLevelSp);

        uC = new UserController(getApplicationContext());

        spinnerAdapterUI();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usr = new User(etId.getText().toString(),
                        etName.getText().toString(),
                        spStratum.getSelectedItem().toString(),
                        etWage.getText().toString(),
                        spEduLevel.getSelectedItem().toString()
                );

                Toast.makeText(getApplicationContext(), usr.name, Toast.LENGTH_SHORT).show();

                if (!uC.findUser(usr.id)) {
                    Log.d("Buscar", "User not found");
                    Toast.makeText(getApplicationContext(), "Usuario Registrado", Toast.LENGTH_SHORT).show();
                    uC.registerUser(usr);
                    clearForm();
                } else {
                    Log.d("Buscar", "User found");
                    Toast.makeText(getApplicationContext(), "Usuario Previamente Registrado", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegistrationActivity.this, MainActivity.class);
                startActivity(i);
                clearForm();
            }
        });


    }

    public void spinnerAdapterUI() {

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

        switch (parent.getId()) {
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

    public void clearForm() {

        if (etId.length() > 0) {
            etId.setText(null);
        }
        if (etName.length() > 0) {
            etName.setText(null);
        }
        spStratum.setSelection(0);

        if (etWage.length() > 0) {
            etWage.setText(null);
        }

        spEduLevel.setSelection(0);
    }

}
