package com.example.prac12;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    DBHelper db;
    EditText editName;
    Button btnInsert, btnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DBHelper(this);

        editName = findViewById(R.id.editName);
        btnInsert = findViewById(R.id.btnInsert);
        btnView = findViewById(R.id.btnView);

        btnInsert.setOnClickListener(v -> {
            String name = editName.getText().toString();
            if (name.isEmpty()) {
                Toast.makeText(this, "Please enter a name", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean isInserted = db.insertData(name);
            Toast.makeText(this,
                    isInserted ? "Data Inserted" : "Error",
                    Toast.LENGTH_SHORT).show();
            editName.setText("");
        });

        btnView.setOnClickListener(v -> {
            Cursor cursor = db.getData();
            if (cursor.getCount() == 0) {
                Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
                return;
            }

            StringBuilder buffer = new StringBuilder();
            while (cursor.moveToNext()) {
                buffer.append("ID: ").append(cursor.getInt(0)).append("\n");
                buffer.append("Name: ").append(cursor.getString(1)).append("\n\n");
            }
            cursor.close();

            Toast.makeText(this, buffer.toString(), Toast.LENGTH_LONG).show();
        });
    }
}