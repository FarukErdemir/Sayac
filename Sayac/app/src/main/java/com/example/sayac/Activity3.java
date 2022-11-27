package com.example.sayac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

    int limitsayustt=0;
    int limitsayaltt=0;

    TextView limitsayust,limitsayalt;
    Button limit_arttirust,limit_azaltust,limitarttiralt,limitazaltalt;
    Switch titresim;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    SharedPreferences.Editor editor2;

    boolean acik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        titresim=findViewById(R.id.Ayar_switch);

        limitsayalt=findViewById(R.id.Limitalt);
        limitsayust=findViewById(R.id.Limitust);

        limit_arttirust=findViewById(R.id.Limit_arttirust);
        limit_azaltust=findViewById(R.id.Limit_azaltust);

        limitarttiralt=findViewById(R.id.limit_arttiralt);
        limitazaltalt=findViewById(R.id.limit_azaltalt);

        Context context=getApplicationContext();
        sharedPreferences =context.getSharedPreferences(context.getPackageName(),context.MODE_PRIVATE);
        editor =sharedPreferences.edit();
        editor2=sharedPreferences.edit();

        limit_arttirust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limitsayustt++;
                limitsayust.setText(String.valueOf(limitsayustt));
            }
        });
        limit_azaltust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limitsayustt--;
                limitsayust.setText(String.valueOf(limitsayustt));
            }
        });

        limitarttiralt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limitsayaltt++;
                limitsayalt.setText(String.valueOf(limitsayaltt));
            }
        });

        limitazaltalt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limitsayaltt--;
                limitsayalt.setText(String.valueOf(limitsayaltt));
            }
        });
    }
    @Override
    protected  void onPause() {
        if (titresim.isChecked()){
            acik=true;
        }
        editor.putInt("UpperLimit",limitsayustt);
        editor2.putInt("DownLimit",limitsayaltt);
        editor2.putBoolean("Switch",acik);
        editor.commit();
        editor2.commit();
        super.onPause();
    }
}