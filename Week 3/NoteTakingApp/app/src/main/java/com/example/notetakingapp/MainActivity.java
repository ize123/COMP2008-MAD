package com.example.notetakingapp;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button addButton;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    String note = "";
    List<String> notes = new ArrayList<>();

    ActivityResultLauncher<Intent> detailActivityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if(result.getResultCode()==RESULT_OK){
                    Intent intent = result.getData();
                    note = intent.getStringExtra("NOTE");
                    if(notes.size() < 4)
                        notes.add(note);
                    updateButtons();
                    addButton.setAlpha(1.0f);
                    addButton.setEnabled(true);
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButton = findViewById(R.id.addButton);

        button1 = findViewById(R.id.note1);
        button2 = findViewById(R.id.note2);
        button3 = findViewById(R.id.note3);
        button4 = findViewById(R.id.note4);

        setInvisible(button1, true);
        setInvisible(button2, true);
        setInvisible(button3, true);
        setInvisible(button4, true);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                detailActivityLauncher.launch(intent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void updateButtons()
    {
        Button[] buttons = {button1, button2, button3, button4};
        if (notes.size() == 4) {
            addButton.setEnabled(false);
            addButton.setClickable(false);
        }
        else {
            addButton.setClickable(true);
            addButton.setEnabled(true);
        }

        for(int i = 0; i < notes.size(); i++)
        {
            setInvisible(buttons[i], false);
        }
    }

    public void setInvisible(Button button, boolean bool)
    {
        if(bool == true)
        {
            button.setVisibility(View.INVISIBLE);
            button.setVisibility(View.GONE);
        }
        else
        {
            button.setVisibility(View.VISIBLE);
        }
    }
}