package com.example.simplestopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     TextView textViewTime;
     Button butonStart,butonStop,butonClean;
     Runnable runnable;
     Handler handler;
     int number;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewTime=findViewById(R.id.textViewTime);
        butonStart=findViewById(R.id.buttonStart);
        butonStop=findViewById(R.id.buttonStop);
        butonClean=findViewById(R.id.buttonClean);
        number=0;
        textViewTime.setText("->  "+number);
    }
    public void start (View view){
        handler=new Handler();
        runnable =new Runnable() {
            @Override
            public void run() {

                textViewTime.setText("->  "+number);
                number++;
                textViewTime.setText("->  "+number);
                handler.postDelayed(runnable,1000);

            }
        };
          handler.post(runnable);
          butonStart.setEnabled(false);
          butonStop.setEnabled(true);
          butonClean.setEnabled(false);
    }
    public void stop (View view){
        butonStart.setEnabled(true);
        handler.removeCallbacks(runnable);
        butonStop.setEnabled(false);
        butonClean.setEnabled(true);
    }
    public void clean (View view){
       number=0;
       textViewTime.setText("->  "+number);
    }
}