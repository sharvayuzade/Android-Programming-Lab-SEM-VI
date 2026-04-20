package com.example.practical7;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editName;
    CheckBox checkJava, checkAndroid;
    RadioGroup radioGroup;
    Button btnSubmit;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editName);
        checkJava = findViewById(R.id.checkJava);
        checkAndroid = findViewById(R.id.checkAndroid);
        radioGroup = findViewById(R.id.radioGroup);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResult = findViewById(R.id.tvResults);

        btnSubmit.setOnClickListener(view -> {

            String name = editName.getText().toString();

            String skills = "";
            if (checkJava.isChecked()) {
                skills += "Java ";
            }

            if (checkAndroid.isChecked()) {
                skills += "Android";
            }

            int selectedId = radioGroup.getCheckedRadioButtonId();

            String gender = "Not selected";
            if (selectedId != -1) {
                RadioButton radioButton = findViewById(selectedId);
                gender = radioButton.getText().toString();
            }

            String result = "Name: " + name +
                    "\nSkills: " + skills +
                    "\nGender: " + gender;

            tvResult.setText(result);
        });
    }
}