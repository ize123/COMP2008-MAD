package com.example.notetakingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailActivity extends AppCompatActivity {

    EditText note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        note = findViewById(R.id.edittext);
        Button saveButton = findViewById(R.id.saveButton);

        if(savedInstanceState != null)
        {
            String value = savedInstanceState.getString("NOTE");
            note.setText(value);
        }

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent();
                intent.putExtra("NOTE",note.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}