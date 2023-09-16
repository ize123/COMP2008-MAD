package com.example.actvityresultback;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PrintActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);
        TextView nameTextView = findViewById(R.id.textView);
        Button backButton = findViewById(R.id.backButtonPrint);
        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
        nameTextView.setText(name);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PrintActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}