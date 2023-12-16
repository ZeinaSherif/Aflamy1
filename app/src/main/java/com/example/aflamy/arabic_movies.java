package com.example.aflamy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class arabic_movies extends AppCompatActivity {
    ImageButton blueelephant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arabic_movies);
        blueelephant = findViewById(R.id.imageButton3);
        blueelephant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbluelep();

            }
        });

    }
    public void openbluelep(){
        Intent intent = new Intent(this, blue_elephant.class);
        startActivity(intent);
    }
}