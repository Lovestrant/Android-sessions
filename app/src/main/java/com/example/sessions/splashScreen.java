package com.example.sessions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class splashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //Lets initialize the hoandler
    final Handler handler = new Handler(Looper.getMainLooper());

    handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
           // finish();
        }
    }, 2000);
    }
}