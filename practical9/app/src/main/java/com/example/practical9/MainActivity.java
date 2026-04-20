package com.example.practical9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnExplicit, btnImplicitWeb, btnImplicitDial, btnCustomAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnExplicit = findViewById(R.id.btnExplicit);
        btnImplicitWeb = findViewById(R.id.btnImplicitWeb);
        btnImplicitDial = findViewById(R.id.btnImplicitDial);
        btnCustomAction = findViewById(R.id.btnCustomAction);

        // Explicit Intent
        btnExplicit.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });

        // Implicit Intent - Open Website
        btnImplicitWeb.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.google.com"));
            startActivity(intent);
        });

        // Implicit Intent - Open Dialer
        btnImplicitDial.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:1234567890"));
            startActivity(intent);
        });

        // Intent Filter - Custom Action
        btnCustomAction.setOnClickListener(v -> {
            Intent intent = new Intent("com.example.practical9.MY_ACTION");
            startActivity(intent);
        });
    }
}