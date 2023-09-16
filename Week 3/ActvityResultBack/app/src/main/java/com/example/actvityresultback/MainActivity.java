package com.example.actvityresultback;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button detailButton;
    Button printButton;
    int detailActivityChecked =0;
    String name="";
    ActivityResultLauncher<Intent> detailActivityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if(result.getResultCode()==RESULT_OK){
                    Intent intent = result.getData();
                    name = intent.getStringExtra("NAME");
                    detailActivityChecked =1;
                    printButton.setAlpha(1.0f);
                    printButton.setEnabled(true);
                }
            }
    );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        detailButton = findViewById(R.id.detailButton);
        printButton = findViewById(R.id.printButton);
        if(detailActivityChecked==0){
            printButton.setAlpha(.4f);
            printButton.setEnabled(false);
        }

        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                detailActivityLauncher.launch(intent);
            }
        });

        printButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PrintActivity.class);
                intent.putExtra("NAME",name);
                startActivity(intent);
            }
        });
    }
}