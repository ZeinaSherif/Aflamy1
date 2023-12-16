package com.example.aflamy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Admin_english_movies extends AppCompatActivity {

    ImageButton add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_english_movies);
        add = findViewById(R.id.imageButton7);
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
}