package com.edu.uac.co.newtech_exam2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class ModifyUserActivity extends AppCompatActivity {

    private Button btnEdit;
    private EditText etId, etName, etWage;
    private Spinner spStratum, spEduLvl;

    private User usr;
    private UserController uC;

    private ArrayAdapter<CharSequence> stratumSpAdapter;
    private ArrayAdapter<CharSequence> eduLvlSpAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_user);

        uC = new UserController(this);

        initUI();

        usr = (User) getIntent().getExtras().getSerializable("userkey");

        loadUserInformation();
    }

    private void initUI() {

        btnEdit = findViewById(R.id.editUserBtn);
        etId = findViewById(R.id.userIdUpdate);
        etName = findViewById(R.id.userNameUpdate);
        spStratum = findViewById(R.id.userStratumUpdate);
        etWage = findViewById(R.id.userWageUpdate);
        spEduLvl = findViewById(R.id.userEduLevelUpdate);

        stratumSpAdapter = ArrayAdapter.createFromResource(this, R.array.sNumbers, android.R.layout.simple_spinner_dropdown_item);
        eduLvlSpAdapter = ArrayAdapter.createFromResource(this, R.array.eduLevels, android.R.layout.simple_spinner_dropdown_item);
        stratumSpAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        eduLvlSpAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spStratum.setAdapter(stratumSpAdapter);
        spEduLvl.setAdapter(eduLvlSpAdapter);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User userEdited = new User(etId.getText().toString(),
                        etName.getText().toString(),
                        spStratum.getSelectedItem().toString(),
                        etWage.getText().toString(),
                        spEduLvl.getSelectedItem().toString()
                );

                uC.updateUser(userEdited);

                finish();
            }
        });
    }

    private void loadUserInformation() {

        etId.setText(usr.id);
        etName.setText(usr.name);
        setSpinnerText(spStratum, usr.stratum);
        etWage.setText(usr.wage);
        setSpinnerText(spEduLvl, usr.educationLevel);
    }

    private void setSpinnerText(Spinner spinner,String Text) {
        for (int i = 0; i < spinner.getAdapter().getCount(); i++) {
            if (spinner.getAdapter().getItem(i).toString().contains(Text)) {
                spinner.setSelection(i);
            }
        }
    }
}
