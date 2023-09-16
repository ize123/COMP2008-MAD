package com.example.notetakingapp3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailActivity extends AppCompatActivity {

    private static final String NOTE = "com.NoteTakingApp3.note";
    private static final String NUMBER = "com.NoteTakingApp3.number";
    private static final String NEWNOTE = "com.NoteTakingApp3.newnote";
    private static String saved_note;
    EditText note;
    Button saveButton;
    int noteNumber;
    Boolean newNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        note = findViewById(R.id.edittext);
        saveButton = findViewById(R.id.saveButton);
        updateView();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                saved_note = note.getText().toString();
                intent.putExtra(NOTE, saved_note);
                intent.putExtra(NEWNOTE, newNote);
                intent.putExtra(NUMBER, noteNumber);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private void updateView()
    {
        Intent intent = getIntent();
        noteNumber = intent.getIntExtra(NUMBER, 0);
        newNote = intent.getBooleanExtra(NEWNOTE, true);
        String saved_note = intent.getStringExtra(NOTE);

        if(saved_note != null)
            note.setText(saved_note);

        if(newNote)
            saveButton.setText("Save");
        else
            saveButton.setText("Update");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(NOTE,note.getText().toString());
    }

}