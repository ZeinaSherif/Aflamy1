package com.example.aflamy;

// SplashScreenActivity.java
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Add any additional setup or background tasks here

        // Example: Start the main activity after a delay
        new android.os.Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, 2000); // 2000 milliseconds (2 seconds) delay
    }
}
