package com.example.aflamy;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Registration extends AppCompatActivity {
    Button backlog;
    EditText first,last,username,email,passw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        backlog=findViewById(R.id.button);
        first=findViewById(R.id.editTextText2);
        last=findViewById(R.id.editTextText6);
        username=findViewById(R.id.editTextText7);
        email=findViewById(R.id.editTextText8);
        passw=findViewById(R.id.editTextText9);

        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK){
                            Intent data = result.getData();

                        }
                    }
                }
        );
        backlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadData();
                openmain();
            }
        });

    }
    public void openmain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void uploadData() {
        String fname = first.getText().toString();
        String lname = last.getText().toString();
        String usern = username.getText().toString();
        String em = email.getText().toString();
        String pass = passw.getText().toString();

        // Use a unique identifier (e.g., username) as a key
        String userId = usern;

        user user = new user(fname, lname, usern, em, pass);

        FirebaseDatabase.getInstance().getReference("users").child(userId)
                .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Registration.this, "Account Registered", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(Registration.this, "Failed to register account", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Registration.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }}