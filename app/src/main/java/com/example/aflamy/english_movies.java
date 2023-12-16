package com.example.aflamy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class english_movies extends AppCompatActivity {
    ImageButton intersellar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_movies);
        intersellar = findViewById(R.id.imageButton3);
        intersellar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openinter();

            }
        });
    }
    public void openinter(){
        Intent intent = new Intent(this, interstellar.class);
        startActivity(intent);
    }
}