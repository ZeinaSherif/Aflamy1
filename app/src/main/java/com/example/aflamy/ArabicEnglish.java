// ArabicEnglish.java
package com.example.aflamy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ArabicEnglish extends AppCompatActivity {
    ImageButton english, arabic;
    String userType = "default"; // Default value
    TextView welcomeTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arabic_english);
        welcomeTextView =findViewById(R.id.textView25);
        SharedPreferences sp = getApplication().getSharedPreferences("Myuser", Context.MODE_PRIVATE);
        String user=sp.getString("username","");
        welcomeTextView.setText("Welcome "+ user );

        // Initialize userType with a default value or handle null appropriately
        userType = getIntent().getStringExtra("userType");

        // Check if userType is null and handle the case appropriately
        if (userType == null) {
            // Handle the case where "userType" is not present in the Intent
            // You might want to set a default value or finish the activity
            userType = "default"; // Set a default value
            // Alternatively, you can finish the activity and show an error message
            // finish();
            // return;
        }

        english = findViewById(R.id.imageButton);
        arabic = findViewById(R.id.imageButton2);

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                englishopen();
            }
        });

        arabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arabicopen();
            }
        });
    }

    public void englishopen() {
        if (userType.equals("admin")) {
            Intent addMoviesIntent = new Intent(this, Admin_english_movies.class);
            startActivity(addMoviesIntent);
        } else {
            Intent viewMoviesIntent = new Intent(this, english_movies.class);
            startActivity(viewMoviesIntent);
        }
    }

    public void arabicopen() {
        if (userType.equals("admin")) {
            Intent addMoviesIntent2 = new Intent(this, admin_arabic_movies.class);
            startActivity(addMoviesIntent2);
        } else {
            Intent viewMoviesIntent2= new Intent(this, arabic_movies.class);
            startActivity(viewMoviesIntent2);
        }
    }
}
