package com.edu.uac.co.newtech_exam2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class ModifyUserActivity extends AppCompatActivity {

    private Button btnEdit;
    private EditText etId, etName, etWage;
    private Spinner spStratum, spEduLvl;

    private User usr, userEdited;

    private UserController uC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_user);

        uC = new UserController(this);

        btnEdit = findViewById(R.id.editUserBtn);
        etId = findViewById(R.id.userIdUpdate);
        etName = findViewById(R.id.userNameUpdate);
        spStratum = findViewById(R.id.userStratumUpdate);
        etWage = findViewById(R.id.userWageUpdate);
        spEduLvl = findViewById(R.id.userEduLevelUpdate);


        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userEdited = new User(etId.getText().toString(),
                        etName.getText().toString(),
                        spStratum.getSelectedItem().toString(),
                        etWage.getText().toString(),
                        spEduLvl.getSelectedItem().toString()
                );

                uC.updateUser(userEdited);
            }
        });

        usr = (User) getIntent().getExtras().getSerializable("userkey");

        loadUserInformation();
    }

    private void loadUserInformation() {

        etId.setText(usr.id);
        etName.setText(usr.name);
        spStratum.setSelection();
        etWage.setText(usr.wage);
        setSpinnerText();
    }

    private void setSpinnerText(Spinner spinner, String[] Arr, String Text) {
        for (int i = 0; i < spinner.getAdapter().getCount(); i++) {
            if (spinner.getAdapter().getItem(i).toString().contains(Text)) {
                spinner.setSelection(i);
            }
        }
    }
}
