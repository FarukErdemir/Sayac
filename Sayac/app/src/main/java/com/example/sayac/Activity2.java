package com.example.sayac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    int upLimit=100;
    int downLimit=-100;
    int sayacc=0;
    TextView sayac;
    Button arttir,azalt,settings;
    boolean tit;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    SharedPreferences.Editor editor2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Context context= getApplicationContext();
        sharedPreferences=context.getSharedPreferences(context.getPackageName(),context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        editor2=sharedPreferences.edit();

        Vibrator vibe=(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);


        sayac=findViewById(R.id.Sayac);
        arttir=findViewById(R.id.Arttir);
        settings=findViewById(R.id.Settings);

        arttir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sayacc<upLimit){
                    sayacc++;
                    sayac.setText((String.valueOf(sayacc)));
                }
                else if(tit==true){
                    vibe.vibrate(1000);
                }
            }
        });

        azalt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sayacc>downLimit){
                    sayacc--;
                    sayac.setText(String.valueOf(sayacc));
                }
                else if(tit==true){
                    vibe.vibrate(1000);
                }
            }
        });

        settings=findViewById(R.id.Settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c =new Intent(Activity2.this,Activity3.class);
                startActivity(c);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        upLimit=sharedPreferences.getInt("UpperLimit",100);
        downLimit=sharedPreferences.getInt("DownLimit",-100);
        tit=sharedPreferences.getBoolean("Switch",false);
    }

    @Override
    public boolean onKeyDown(int keyCode , KeyEvent event){
        Vibrator vibe =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        if (keyCode==KeyEvent.KEYCODE_VOLUME_UP){
            if (sayacc<upLimit){
                sayacc=sayacc+5;
                sayac.setText(String.valueOf(sayacc));
                return true;
            }
            else if(tit==true){
                vibe.vibrate(1000);
            }
        }
        if (keyCode==KeyEvent.KEYCODE_VOLUME_DOWN){
            if (sayacc>downLimit){
                sayacc=sayacc-5;
                sayac.setText(String.valueOf(sayacc));
                return true;
            }
        }
        else if (tit==true){
            vibe.vibrate(1000);
        }
        return super.dispatchKeyEvent(event);
    }
}