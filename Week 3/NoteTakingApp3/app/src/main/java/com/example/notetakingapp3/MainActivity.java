package com.example.notetakingapp3;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String NOTE = "com.NoteTakingApp3.note";
    private static final String NUMBER = "com.NoteTakingApp3.number";
    private static final String NEWNOTE = "com.NoteTakingApp3.newnote";
    private static final int MAX_NOTES = 4;
    ActivityResultLauncher<Intent> detailActivityLauncher;
    Button addButton, button1, button2, button3, button4;
    String note;
    int noteNumber;
    ArrayList<String> notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notes = new ArrayList<>();
        addButton = findViewById(R.id.addButton);
        button1 = findViewById(R.id.note1);
        button2 = findViewById(R.id.note2);
        button3 = findViewById(R.id.note3);
        button4 = findViewById(R.id.note4);

        setInvisible(button1);
        setInvisible(button2);
        setInvisible(button3);
        setInvisible(button4);

        if(savedInstanceState != null)
        {
            notes = savedInstanceState.getStringArrayList("SAVE");
        }

        //Initialise the ActivityResultLauncher
        detailActivityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if(result.getResultCode()==RESULT_OK){
                        Intent intent = result.getData();
                        note = intent.getStringExtra(NOTE);
                        Boolean newNote = intent.getBooleanExtra(NEWNOTE, true);
                        noteNumber = intent.getIntExtra(NUMBER, 0);

                        //If its not a new note then upate the note
                        if(!newNote)
                            updateNote(note, noteNumber);

                        //If the notes size hasn't reached and it is a new note then add it to the list.
                        if(notes.size() < MAX_NOTES && newNote)
                            notes.add(note);
                        updateButtons();
                    }
                }
        );

        updateButtons();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("NEW NOTE", true);
                detailActivityLauncher.launch(intent);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDetailActivity(notes.get(0), 0);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDetailActivity(notes.get(1), 1);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDetailActivity(notes.get(2), 2);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDetailActivity(notes.get(3), 3);
            }
        });
    }

    public void startDetailActivity(String note, int noteNumber)
    {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(NOTE, note);
        intent.putExtra(NEWNOTE, false);
        intent.putExtra(NUMBER, noteNumber);
        detailActivityLauncher.launch(intent);
    }

    public void updateNote(String note, int index)
    {
        notes.set(index, note);
    }
    public void updateButtons()
    {
        Button[] buttons = {button1, button2, button3, button4};
        int size = notes.size();
        for(int i = 0; i < size; i++)
        {
            setVisible(buttons[i]);
        }
    }

    public void setInvisible(Button button)
    {
        button.setVisibility(View.INVISIBLE);
        button.setVisibility(View.GONE);
    }

    public void setVisible(Button button)
    {
        button.setVisibility(View.VISIBLE);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("SAVE", notes);
    }
}