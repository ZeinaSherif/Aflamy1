package com.example.aflamy;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.icu.text.CaseMap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class add_movies extends AppCompatActivity {
    ImageView uploadMovieImage,uploadAct1,uploadAct2,uploadAct3;
    Button saveEnglish,saveArabic;
    EditText movieName,country,rate,min,year,genre1,genre2,genre3,genre4,desc,actor1,actor2,actor3,name1,name2,name3;
    String imageURL;
    Uri uri;


    private static final int REQUEST_READ_EXTERNAL_STORAGE_PERMISSION = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movies);
        FirebaseApp.initializeApp(this);

        uploadMovieImage =findViewById(R.id.imageView1);
        uploadAct1 =findViewById(R.id.myImageView);
        uploadAct2= findViewById(R.id.myImageView10);
        uploadAct3=findViewById(R.id.myImageView1);
        saveEnglish=findViewById(R.id.button10);
        saveArabic=findViewById(R.id.button11);
        movieName= findViewById(R.id.textView10);
        country= findViewById(R.id.textView23);
        rate= findViewById(R.id.textView24);
        min= findViewById(R.id.textView40);
        year= findViewById(R.id.textView41);
        genre1= findViewById(R.id.textView50);
        genre2= findViewById(R.id.textView51);
        genre3= findViewById(R.id.textView52);
        genre4= findViewById(R.id.textView53);
        desc= findViewById(R.id.textView54);
        actor1= findViewById(R.id.textView55);
        actor2= findViewById(R.id.textView57);
        actor3= findViewById(R.id.textView59);
        name1= findViewById(R.id.textView56);
        name2= findViewById(R.id.textView58);
        name3= findViewById(R.id.textView60);

        ActivityResultLauncher<Intent> activityResultLauncher=registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode()== Activity.RESULT_OK){
                            Intent data=result.getData();
                            uri=data.getData();
                            uploadMovieImage.setImageURI(uri);

                        }
                        else{
                            Toast.makeText(add_movies.this, "No image selected", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
        uploadMovieImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPicker=new Intent(Intent.ACTION_PICK);
                photoPicker.setType("image/*");
                activityResultLauncher.launch(photoPicker);
            }
        });

        saveEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });


    }
    public void saveData(){
        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("android_image").child(uri.getLastPathSegment());
        AlertDialog.Builder builder = new AlertDialog.Builder(add_movies.this);
        builder.setCancelable(false);
        AlertDialog dialog = builder.create();
        dialog.show();

        storageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                storageReference.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> uriTask) {
                        if (uriTask.isSuccessful()) {
                            Uri urlImage = uriTask.getResult();
                            imageURL = urlImage.toString();
                            uploadData();
                            dialog.dismiss();
                        } else {
                            // Handle the failure to get download URL
                            dialog.dismiss();
                        }
                    }
                });
            }

        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                dialog.dismiss();

            }
        });


    }
    public void uploadData (){
        String movieName1 = movieName.getText().toString();
        String country1 = country.getText().toString();
        String rate1 = rate.getText().toString();
        String min1 = min.getText().toString();
        String year1 = year.getText().toString();
        String genre11 = genre1.getText().toString();
        String genre22 = genre2.getText().toString();
        String genre33 = genre3.getText().toString();
        String genre44 = genre4.getText().toString();
        String desc1 = desc.getText().toString();
        String actor11 = actor1.getText().toString();
        String actor22 = actor2.getText().toString();
        String actor33 = actor3.getText().toString();
        String name11 = name1.getText().toString();
        String name22 = name2.getText().toString();
        String name33 = name3.getText().toString();

        uploadMovies uploadMovies = new uploadMovies(imageURL,movieName1,country1,rate1,min1,year1,genre11,genre22,genre33,genre44,desc1,actor11,actor22,actor33,name11,name22,name33);

        FirebaseDatabase.getInstance().getReference("Movie description").child(movieName1).setValue(uploadMovies).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(add_movies.this, "Saved", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(add_movies.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}