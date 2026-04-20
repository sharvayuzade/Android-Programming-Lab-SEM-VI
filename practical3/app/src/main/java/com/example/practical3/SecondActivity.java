package com.example.practical3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Toast.makeText(this, "SecondActivity: onCreate", Toast.LENGTH_SHORT).show();

        EditText etUsername = findViewById(R.id.etUsername);
        EditText etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(SecondActivity.this,
                        "Please enter both username and password",
                        Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(SecondActivity.this, WelcomeActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "SecondActivity: onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "SecondActivity: onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "SecondActivity: onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "SecondActivity: onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "SecondActivity: onDestroy", Toast.LENGTH_SHORT).show();
    }
}