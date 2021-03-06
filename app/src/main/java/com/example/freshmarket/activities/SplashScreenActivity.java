package com.example.freshmarket.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.freshmarket.R;

public class SplashScreenActivity extends AppCompatActivity {
  Handler handler ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this ,OnBoardingActivity.class );
                startActivity(intent);
                finish();
            }
        }, 2500);
    }
}
