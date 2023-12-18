package com.example.aflamy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button reg, login;
    EditText username, password;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

        setContentView(R.layout.activity_main);

        reg = findViewById(R.id.button4);
        login = findViewById(R.id.button3);
        username = findViewById(R.id.editTextText);
        password = findViewById(R.id.editTextTextPassword);
        sharedPreferences = getSharedPreferences("Myuser", Context.MODE_PRIVATE);
        BroadcastReceiver br = new MyReceiver();
        IntentFilter f1 = new IntentFilter(Intent.ACTION_BATTERY_LOW);
        registerReceiver(br,f1);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredUsername = username.getText().toString().trim();
                String enteredPassword = password.getText().toString().trim();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", enteredUsername);
                editor.commit();

                if (enteredUsername.equals("admin") && enteredPassword.equals("admin")) {
                    // Admin login: Go to arabicEnglishMovies and then to addMovies
                    Intent adminIntent = new Intent(MainActivity.this, ArabicEnglish.class);
                    adminIntent.putExtra("userType", "admin");
                    startActivity(adminIntent);
                } else {
                    DatabaseReference usersReference = FirebaseDatabase.getInstance().getReference().child("users");

                    usersReference.child(enteredUsername).get().addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            if (task.getResult().exists()) {
                                String storedPassword = task.getResult().child("pass").getValue(String.class);
                                if (enteredPassword.equals(storedPassword)) {
                                    // Correct username and password: Go to the ArabicEnglish activity for users
                                    Intent userIntent = new Intent(MainActivity.this, ArabicEnglish.class);
                                    userIntent.putExtra("userType", "user");
                                    startActivity(userIntent);
                                } else {
                                    // Incorrect password: Display a toast message
                                    Toast.makeText(MainActivity.this, "Incorrect password", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                // User not found: Display a toast message and provide an option to register
                                Toast.makeText(MainActivity.this, "Account not found", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            // Error in database query: Display a toast message
                            Toast.makeText(MainActivity.this, "Error accessing database", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegister();
            }
        });
    }

    public void openRegister() {
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }
}
