package com.example.aflamy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class admin_arabic_movies extends AppCompatActivity {

    ImageButton add,blueelephant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_arabic_movies);
        add = findViewById(R.id.imageButton7);
        blueelephant = findViewById(R.id.imageButton3);
        blueelephant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbluelep();

            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMovie();
            }
        });
    }
    public void addMovie(){
        Intent intent = new Intent(this, add_movies.class);
        startActivity(intent);
    }
    public void openbluelep(){
        Intent intent = new Intent(this, blue_elephant.class);
        startActivity(intent);
    }
}