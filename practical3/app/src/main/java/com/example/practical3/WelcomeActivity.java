package com.example.practical3;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Toast.makeText(this, "WelcomeActivity: onCreate", Toast.LENGTH_SHORT).show();

        TextView tvWelcome = findViewById(R.id.tvWelcome);

        String username = getIntent().getStringExtra("username");
        tvWelcome.setText("Welcome, " + username + "!");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "WelcomeActivity: onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "WelcomeActivity: onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "WelcomeActivity: onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "WelcomeActivity: onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "WelcomeActivity: onDestroy", Toast.LENGTH_SHORT).show();
    }
}