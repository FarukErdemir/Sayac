package com.example.sayac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class MainActivity extends AppCompatActivity {

    Handler a=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent b=new Intent(MainActivity.this,Activity2.class);
            }
        },2000);
    }
}